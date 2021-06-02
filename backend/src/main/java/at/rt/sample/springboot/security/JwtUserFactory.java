package at.rt.sample.springboot.security;

import at.rt.sample.springboot.models.Authority;
import at.rt.sample.springboot.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user, Collection<Authority> authorities) {

        return new JwtUser()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setAuthorities(mapToGrantedAuthorities(authorities))
                .setLastPasswordResetDate(user.getLastPasswordReset())
                .setEnabled(true);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }
}
