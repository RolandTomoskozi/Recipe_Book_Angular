package at.rt.sample.springboot.service.api;

import at.rt.sample.springboot.dto.model.IngredientModel;
import at.rt.sample.springboot.dto.model.RecipeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service-Interface fuer den Zugriff auf Ingredients.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface IIngredientsService {

    IngredientModel findById(Long id);
    Page<IngredientModel> findAll(Pageable pageable, Optional<String> filter);
    IngredientModel createIngredient(IngredientModel ingredientModel);
    void deleteIngredient(IngredientModel ingredientModel);
}
