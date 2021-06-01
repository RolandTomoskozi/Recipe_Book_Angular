package at.rt.sample.springboot.dto.model;

import at.rt.sample.springboot.dto.model.base.BaseModel;
import at.rt.sample.springboot.models.ShoppingList;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO kapselt die ShoppingLists und die Anzahl deren Ingredients.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShoppingListModel extends BaseModel<Long> {
    private ShoppingList shoppingList;
    private Long anzahlVonIngredients;
}
