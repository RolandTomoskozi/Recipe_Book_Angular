package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

    void deleteByUserIdAndAuthorityIdIn(Long userId, Collection<Long> authorityId);
}
