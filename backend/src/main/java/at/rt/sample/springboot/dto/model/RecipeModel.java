package at.rt.sample.springboot.dto.model;

import at.rt.sample.springboot.dto.model.base.BaseModel;
import at.rt.sample.springboot.models.Recipe;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO kapselt die Recipes.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RecipeModel extends BaseModel<Long> {
    private Recipe recipe;
}
