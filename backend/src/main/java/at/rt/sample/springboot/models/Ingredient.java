package at.rt.sample.springboot.models;

import at.rt.sample.springboot.models.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "INGREDIENT")
@Data
public class Ingredient extends BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "SQX_INGREDIENT")
    @SequenceGenerator(name = "SQX_INGREDIENT", sequenceName = "SQX_INGREDIENT")
    private Long id;

    @NotBlank
    @Length(min = 3, max = 20)
    @Column(name = "INGREDIENT_NAME")
    private String name;

    @NotNull
    @Column(name = "AMOUNT")
    private int amount;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> recipe;
}
