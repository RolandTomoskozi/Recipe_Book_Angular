package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    @Query("select i from Ingredient i where LOWER(i.name) like concat('%', lower(?1), '%')")
    Page<Ingredient> findAllByFilter(String filter, Pageable pageable);
}
