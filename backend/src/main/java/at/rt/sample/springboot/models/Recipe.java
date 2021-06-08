package at.rt.sample.springboot.models;

import at.rt.sample.springboot.models.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RECIPE")
@Data
public class Recipe extends BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "SQX_RECIPE")
    @SequenceGenerator(name = "SQX_RECIPE", sequenceName = "SQX_RECIPE")
    private Long id;

    @NotBlank
    @Length(min = 3, max = 50)
    @Column(name = "RECIPE_NAME")
    private String name;

    @NotBlank
    @Length(min = 3, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;

    @NotBlank
    @Column(name = "IMAGEPATH")
    private String imagePath;

    @ManyToMany
    @JoinTable(
            name = "ingredient_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
    @JoinColumn(name = "ingredient_id")
    private Set<Ingredient> ingredients;
}
