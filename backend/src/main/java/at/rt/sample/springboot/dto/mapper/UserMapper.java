package at.rt.sample.springboot.dto.mapper;

import at.rt.sample.springboot.dto.mapper.base.BaseMapper;
import at.rt.sample.springboot.dto.model.UserModel;
import at.rt.sample.springboot.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = JpaVersionMapper.class)
public interface UserMapper extends BaseMapper<UserModel, User> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "authorities", ignore = true)})
    @Override
    UserModel entityToModel(User entity);

    @Mapping(target = "lastPasswordReset", ignore = true)
    @Override
    User modelToEntity(UserModel model);

    @Mappings({
            @Mapping(target = "lastPasswordReset", ignore = true),
            @Mapping(target = "password", ignore = true)})
    @Override
    void updateEntityFromModel(UserModel model, @MappingTarget User entity);
}
