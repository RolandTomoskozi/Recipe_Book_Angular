package at.rt.sample.springboot.dto.model;

import at.rt.sample.springboot.dto.model.base.BaseModel;
import at.rt.sample.springboot.models.Ingredient;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO kapselt die Ingredients und die Anzahl.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IngredientModel extends BaseModel<Long> {
    private Ingredient ingredient;
    private Long anzahlVonIngredients;
}
