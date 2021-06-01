package at.rt.sample.springboot.repo;

import at.rt.sample.springboot.models.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("select r from Recipe r where LOWER(r.recipeName) like concat('%', lower(?1), '%')")
    Page<Recipe> findAllByFilter(String filter, Pageable pageable);
}
