package at.rt.sample.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * enable {@link org.springframework.data.annotation.CreatedBy}, {@link org.springframework.data.annotation.LastModifiedBy},
 * {@link org.springframework.data.annotation.CreatedDate} and {@link org.springframework.data.annotation.LastModifiedDate}
 * on JPA Entities
 */
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableSpringDataWebSupport
@Configuration
public class GlobalJpaConfiguration {

    /**
     * this bean is used to inject the correct data into Entities with {@link org.springframework.data.annotation.CreatedBy}
     * and {@link org.springframework.data.annotation.LastModifiedBy}
     */
    @Bean
    public AuditorAware<String> springSecurityAuditorAware() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getName);
    }

}
