package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.Authority;
import java.util.Collection;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public interface AuthorityRepositoryCustom {

    Collection<Authority> findByUserId(Long userId);
}
