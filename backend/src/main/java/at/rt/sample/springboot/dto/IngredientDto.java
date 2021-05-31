package at.rt.sample.springboot.dto;

import at.rt.sample.springboot.models.Ingredient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO kapselt die Zutaten und die Anzahl.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@Data
@NoArgsConstructor
public class IngredientDto implements Serializable {
    private Ingredient ingredient;
    private Long anzahlVonIngredients;
}
