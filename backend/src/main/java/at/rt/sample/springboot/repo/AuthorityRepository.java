package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long>, AuthorityRepositoryCustom {

    Authority findByName(String name);
}
