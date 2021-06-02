package at.rt.sample.springboot.service.impl;

import at.rt.sample.springboot.dto.mapper.UserMapper;
import at.rt.sample.springboot.dto.model.UserModel;
import at.rt.sample.springboot.models.Authority;
import at.rt.sample.springboot.models.User;
import at.rt.sample.springboot.models.UserAuthority;
import at.rt.sample.springboot.repo.AuthorityRepository;
import at.rt.sample.springboot.repo.UserAuthorityRepository;
import at.rt.sample.springboot.repo.UserRepository;
import at.rt.sample.springboot.security.JwtUser;
import at.rt.sample.springboot.service.api.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final UserAuthorityRepository userAuthorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           AuthorityRepository authorityRepository, UserAuthorityRepository userAuthorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAuthorityRepository = userAuthorityRepository;
    }

    @Override
    public UserModel findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::entityToModel)
                .map(this::addAuthoritesToUser)
                .orElseThrow(() -> new NullPointerException("cannot find user with given id"));
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::entityToModel)
                .map(this::addAuthoritesToUser);
    }

    @Transactional
    @Override
    public UserModel createUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User userToSave = userMapper.modelToEntity(user);
        userToSave.setLastPasswordReset(new Date());
        UserModel userModel = userMapper.entityToModel(userRepository.save(userToSave));
        for (String authority : user.getAuthorities()) {
            Authority auth = authorityRepository.findByName(authority);
            userAuthorityRepository.save(createUserAuhority(userModel.getId(), auth.getId()));
            userModel.getAuthorities().add(authority);
        }
        return userModel;
    }

    @Transactional
    @Override
    public void updateUser(UserModel user) {
        User entity = userRepository.findById(user.getId()).orElseThrow(() -> new NullPointerException("Can't find user with given id!"));
        userMapper.updateEntityFromModel(user, entity);
        userRepository.save(entity);
        // create diff of authorities to delete or add
        List<String> authorities = user.getAuthorities();
        Collection<Authority> existing = authorityRepository.findByUserId(user.getId());
        for (String authority : authorities) {
            Optional<Authority> found = existing.stream().filter(auth -> auth.getName().compareTo(authority) == 0).findAny();
            if (found.isPresent()) {
                // nothing to do, remove from existing list
                existing.remove(found.get());
            } else {
                // new authority, so add it
                userAuthorityRepository.save(createUserAuhority(user.getId(), authorityRepository.findByName(authority).getId()));
            }
        }
        // delete authorities which are not in the given list
        userAuthorityRepository.deleteByUserIdAndAuthorityIdIn(user.getId(), existing.stream().map(Authority::getId).collect(Collectors.toList()));
    }

    @Override
    public Long getCurrentUserId() {
        return ((JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

    private UserModel addAuthoritesToUser(UserModel userModel) {
        userModel.setAuthorities(
                authorityRepository.findByUserId(userModel.getId())
                        .stream()
                        .map(authority -> authority.getName())
                        .collect(Collectors.toList())
        );
        return userModel;
    }

    private UserAuthority createUserAuhority(Long userId, Long authorityId) {
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setUserId(userId);
        userAuthority.setAuthorityId(authorityId);
        return userAuthority;
    }

}
