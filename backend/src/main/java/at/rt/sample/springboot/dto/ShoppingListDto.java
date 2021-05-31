package at.rt.sample.springboot.dto;

import at.rt.sample.springboot.models.ShoppingList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO kapselt die Einkaufsliste und die Anzahl deren Zutaten.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@Data
@NoArgsConstructor
public class ShoppingListDto implements Serializable {
    private ShoppingList shoppingList;
    private Long anzahlVonIngredients;
}
