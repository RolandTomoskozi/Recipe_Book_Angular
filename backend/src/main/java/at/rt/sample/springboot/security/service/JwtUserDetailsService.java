package at.rt.sample.springboot.security.service;

import at.rt.sample.springboot.repo.AuthorityRepository;
import at.rt.sample.springboot.repo.UserRepository;
import at.rt.sample.springboot.security.JwtUserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public JwtUserDetailsService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> JwtUserFactory.create(user, authorityRepository.findByUserId(user.getId())))
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("can't find user with username '%s'", username)));
    }
}
