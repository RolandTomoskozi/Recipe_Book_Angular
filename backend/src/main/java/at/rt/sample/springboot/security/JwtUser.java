package at.rt.sample.springboot.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * User welcher im JWT Token serialisiert wird.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public class JwtUser implements UserDetails {

    @JsonIgnore
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    private Date lastPasswordResetDate;
    private Boolean enabled;

    public JwtUser setId(Long id) {
        this.id = id;
        return this;
    }

    public JwtUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public JwtUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public JwtUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public JwtUser setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }

    public JwtUser setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
        return this;
    }

    public JwtUser setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtUser jwtUser = (JwtUser) o;
        return Objects.equals(id, jwtUser.id) &&
                Objects.equals(username, jwtUser.username) &&
                Objects.equals(password, jwtUser.password) &&
                Objects.equals(email, jwtUser.email) &&
                Objects.equals(authorities, jwtUser.authorities) &&
                Objects.equals(lastPasswordResetDate, jwtUser.lastPasswordResetDate) &&
                Objects.equals(enabled, jwtUser.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, authorities, lastPasswordResetDate, enabled);
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", authorities=" + authorities +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", enabled=" + enabled +
                '}';
    }
}
