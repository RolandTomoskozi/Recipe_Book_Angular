package at.rt.sample.springboot.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SHOPPINGLIST")
@Data
public class ShoppingList extends Ingredient {

    @NotBlank
    @Length(min = 3, max = 20)
    @Column(name = "SHOPPINGLIST_NAME")
    private String name;
}
