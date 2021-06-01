package at.rt.sample.springboot.dto.mapper;

import at.rt.sample.springboot.dto.mapper.base.BaseMapper;
import at.rt.sample.springboot.dto.model.IngredientModel;
import at.rt.sample.springboot.models.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 01.06.2021
 */
@Mapper(uses = JpaVersionMapper.class)
public interface IngredientMapper extends BaseMapper<IngredientModel, Ingredient> {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    @Override
    Ingredient modelToEntity(IngredientModel model);

    @Override
    IngredientModel entityToModel(Ingredient ingredient);

    @Override
    void updateEntityFromModel(IngredientModel model, @MappingTarget Ingredient entity);
}
