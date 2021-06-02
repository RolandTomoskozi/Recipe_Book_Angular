package at.rt.sample.springboot.models;

import at.rt.sample.springboot.models.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER")
@Data
public class User extends BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "SQX_USER")
    @SequenceGenerator(name = "SQX_USER", sequenceName = "SQX_USER")
    private Long id;

    @Column(name = "USERNAME", unique = true)
    @Length(min = 4, max = 24)
    @NotNull
    private String username;

    @Column(name = "EMAIL", unique = true)
    @Email
    @NotNull
    private String email;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "LAST_PASSWORD_RESET", columnDefinition = "DATE")
    private Date lastPasswordReset;

    @Version
    private Long version;
}
