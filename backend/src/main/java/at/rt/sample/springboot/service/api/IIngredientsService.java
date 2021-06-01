package at.rt.sample.springboot.service.api;

import at.rt.sample.springboot.models.Ingredient;

import java.util.List;
import java.util.Optional;

/**
 * Service-Interface fuer den Zugriff auf Ingredients.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface IIngredientsService {

    /**
     * Liefert die Liste aller Ingredients, sortiert nach der Bezeichnung.
     *
     * @return Liste von Recipies
     */
    List<Ingredient> listIngredients();

    /**
     * Sucht eine Ingredient anhand der ID.
     *
     * @param id ID der Ingredient
     * @return gefundene Ingredient
     */
    Optional<Ingredient> getIngredientById(Long id);

    /**
     * Speichert eine Ingredient.
     *
     * @param ingredient Zu speichernde Ingredient
     * @return gespeicherte Ingredient
     */
    Ingredient saveRecipie(Ingredient ingredient);

    /**
     * Löscht eine Ingredient anhand der ID.
     *
     * @param id ID der Ingredient
     */
    void deleteIngredient(Long id);
}
