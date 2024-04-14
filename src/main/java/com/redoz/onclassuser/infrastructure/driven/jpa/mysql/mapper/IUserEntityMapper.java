package com.redoz.onclassuser.infrastructure.driven.jpa.mysql.mapper;

import com.redoz.onclassuser.domain.model.User;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    UserEntity toEntity(User user);

    List<User> toModelList(List<UserEntity> userEntities);

    User toModel(UserEntity userEntity);
}
