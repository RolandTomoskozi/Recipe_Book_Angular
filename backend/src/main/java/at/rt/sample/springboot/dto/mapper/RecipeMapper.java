package at.rt.sample.springboot.dto.mapper;

import at.rt.sample.springboot.dto.mapper.base.BaseMapper;
import at.rt.sample.springboot.dto.model.RecipeModel;
import at.rt.sample.springboot.models.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 01.06.2021
 */
@Mapper(uses = JpaVersionMapper.class)
public interface RecipeMapper extends BaseMapper<RecipeModel, Recipe> {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    @Override
    Recipe modelToEntity(RecipeModel model);

    @Override
    RecipeModel entityToModel(Recipe recipe);

    @Override
    void updateEntityFromModel(RecipeModel model, @MappingTarget Recipe entity);
}
