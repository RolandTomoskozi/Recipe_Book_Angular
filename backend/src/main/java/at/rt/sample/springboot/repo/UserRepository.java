package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = ?1 or u.email = ?1")
    Optional<User> findByUsername(String usernameOrEmail);
}
