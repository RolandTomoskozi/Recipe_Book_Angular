package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {
}
