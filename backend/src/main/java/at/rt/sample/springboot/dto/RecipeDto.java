package at.rt.sample.springboot.dto;

import at.rt.sample.springboot.models.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO kapselt die Rezepte.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@Data
@AllArgsConstructor
public class RecipeDto implements Serializable {
    private Recipe recipe;
}
