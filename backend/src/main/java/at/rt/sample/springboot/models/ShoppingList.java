package at.rt.sample.springboot.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SHOPPINGLIST")
@Data
public class ShoppingList extends Ingredient {
}
