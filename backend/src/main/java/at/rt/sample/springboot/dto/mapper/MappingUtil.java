package at.rt.sample.springboot.dto.mapper;

import at.rt.sample.springboot.models.Authority;
import at.rt.sample.springboot.repo.AuthorityRepository;
import at.rt.sample.springboot.service.api.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MappingUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static ApplicationContext applicationContext() {
        return applicationContext;
    }

    public static List<String> mapAuthorities(Collection<Authority> authorities) {
        return authorities
                .stream()
                .map(Authority::getName)
                .collect(Collectors.toList());
    }

    public static List<Authority> mapAuthorityModels(Collection<String> authorities) {
        AuthorityRepository repository = applicationContext.getBean(AuthorityRepository.class);
        return authorities.stream().map(repository::findByName).collect(Collectors.toList());
    }

    public static Long currentUserId() {
        UserService userService = applicationContext.getBean(UserService.class);
        return userService.getCurrentUserId();
    }

    protected MappingUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MappingUtil.applicationContext = applicationContext;
    }
}
