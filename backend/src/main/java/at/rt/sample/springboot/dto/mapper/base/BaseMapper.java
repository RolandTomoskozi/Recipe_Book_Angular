package at.rt.sample.springboot.dto.mapper.base;

import at.rt.sample.springboot.models.base.BaseEntity;
import org.mapstruct.MappingTarget;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 31.05.2021
 */
public interface BaseMapper<M, E extends BaseEntity<?>> {

    E modelToEntity(M model);

    M entityToModel(E entity);

    void updateEntityFromModel(M model, @MappingTarget E entity);
}
