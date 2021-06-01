package at.rt.sample.springboot.dto.mapper;

import at.rt.sample.springboot.dto.mapper.base.BaseMapper;
import at.rt.sample.springboot.dto.model.ShoppingListModel;
import at.rt.sample.springboot.models.ShoppingList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 01.06.2021
 */
@Mapper(uses = JpaVersionMapper.class)
public interface ShoppingListMapper extends BaseMapper<ShoppingListModel, ShoppingList> {

    ShoppingListMapper INSTANCE = Mappers.getMapper(ShoppingListMapper.class);

    @Override
    ShoppingList modelToEntity(ShoppingListModel model);

    @Override
    ShoppingListModel entityToModel(ShoppingList shoppingList);

    @Override
    void updateEntityFromModel(ShoppingListModel model, @MappingTarget ShoppingList entity);
}
