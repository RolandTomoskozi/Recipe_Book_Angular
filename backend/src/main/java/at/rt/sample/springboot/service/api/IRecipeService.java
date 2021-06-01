package at.rt.sample.springboot.service.api;

import at.rt.sample.springboot.models.Recipe;

import java.util.List;
import java.util.Optional;

/**
 * Service-Interface fuer den Zugriff auf Recipe.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface IRecipeService {

    /**
     * Liefert die Liste aller Recipes, sortiert nach der Bezeichnung.
     *
     * @return Liste von Recipes
     */
    List<Recipe> listRecipes();

    /**
     * Sucht eine Recipe anhand der ID
     *
     * @param id ID der Recipe
     * @return gefundene Recipe
     */
    Optional<Recipe> getRecipeById(Long id);

    /**
     * Speichert eine Recipe.
     *
     * @param recipe Zu speichernde Recipe
     * @return gespeicherte Recipe
     */
    Recipe saveRecipe(Recipe recipe);

    /**
     * Löscht eine Recipie anhand der ID.
     *
     * @param id ID der Recipie
     */
    void deleteRecipe(Long id);
}
