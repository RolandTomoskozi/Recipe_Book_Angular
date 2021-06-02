package at.rt.sample.springboot.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public class WithMockJwtUserSecurityContextFactory implements WithSecurityContextFactory<WithMockJwtUser> {
    @Override
    public SecurityContext createSecurityContext(WithMockJwtUser annotation) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        JwtUser jwtUser = new JwtUser()
                .setEnabled(true)
                .setLastPasswordResetDate(new Date())
                .setUsername(annotation.username())
                .setId(annotation.id())
                .setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(Arrays.asList(annotation.roles())
                        .stream()
                        .map(role -> "ROLE_" + role).collect(Collectors.joining(","))));

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(jwtUser, "pw", jwtUser.getAuthorities());
        context.setAuthentication(auth);

        return context;
    }
}
