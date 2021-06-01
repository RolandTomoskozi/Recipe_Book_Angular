package at.rt.sample.springboot.dto.model.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
@Data
public class BaseModel<ID extends Serializable> {
    private ID id;
}
