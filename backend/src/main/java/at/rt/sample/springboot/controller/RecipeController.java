package at.rt.sample.springboot.controller;

import at.rt.sample.springboot.dto.model.RecipeModel;
import at.rt.sample.springboot.models.Recipe;
import at.rt.sample.springboot.service.api.IRecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 01.06.2021
 */
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final IRecipeService recipeService;

    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeModel createRecipe(@RequestBody @Valid RecipeModel recipeModel) {
        return recipeService.createRecipe(recipeModel);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody RecipeModel newRecipe) {
        return recipeService.updateRecipe(id, newRecipe);
    }

    @GetMapping("/findAll")
    public Page<RecipeModel> findAll(@PageableDefault Pageable pageable,
                                     @RequestParam("filter") Optional<String> filter) {
        return recipeService.findAll(pageable, filter);
    }

    @GetMapping("/{id}")
    public RecipeModel findOne(@PathVariable("id") Long id) {
        return recipeService.findById(id);
    }
}
