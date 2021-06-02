package at.rt.sample.springboot.models;

import at.rt.sample.springboot.models.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "AUTHORITY")
@Data
public class Authority extends BaseEntity<Long> {

    @Id
    @GeneratedValue(generator = "SQX_AUTHORITY")
    @SequenceGenerator(name = "SQX_AUTHORITY", sequenceName = "SQX_AUTHORITY")
    private Long id;

    @NotEmpty
    private String name;
}
