package at.rt.sample.springboot.repo.impl;

import at.rt.sample.springboot.models.Authority;
import at.rt.sample.springboot.repo.AuthorityRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.Collection;

import static at.rt.sample.springboot.models.QUserAuthority.userAuthority;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public class AuthorityRepositoryImpl implements AuthorityRepositoryCustom {

    private final EntityManager entityManager;

    public AuthorityRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Collection<Authority> findByUserId(Long userId) {
        return new JPAQueryFactory(entityManager)
                .select(userAuthority.authority)
                .from(userAuthority)
                .where(userAuthority.userId.eq(userId))
                .fetch();
    }
}
