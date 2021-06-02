package at.rt.sample.springboot.models;

import at.rt.sample.springboot.models.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER_AUTHORITY")
@Data
public class UserAuthority extends BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "SQX_USER_AUTHORITY")
    @SequenceGenerator(name = "SQX_USER_AUTHORITY", sequenceName = "SQX_USER_AUTHORITY")
    private Long id;

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USER_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_USRAUT_USER"))
    private User user;

    @NotNull
    @Column(name = "AUTHORITY_ID", nullable = false)
    private Long authorityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "AUTHORITY_ID",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_USRAUT_AUTH"))
    private Authority authority;
}
