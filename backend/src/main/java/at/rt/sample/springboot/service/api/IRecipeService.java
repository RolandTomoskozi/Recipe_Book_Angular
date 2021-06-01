package at.rt.sample.springboot.service.api;

import at.rt.sample.springboot.dto.model.RecipeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service-Interface fuer den Zugriff auf Recipe.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface IRecipeService {

    RecipeModel findById(Long id);
    Page<RecipeModel> findAll(Pageable pageable, Optional<String> filter);
    RecipeModel createRecipe(RecipeModel recipeModel);
    void deleteRecipe(RecipeModel recipeModel);
}
