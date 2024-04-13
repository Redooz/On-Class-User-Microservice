package com.redoz.onclassuser.application.mapper;

import com.redoz.onclassuser.application.dto.request.RegisterUserRequest;
import com.redoz.onclassuser.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IAuthRequestMapper {
    @Mapping(target = "role", ignore = true)
    User toUserModel(RegisterUserRequest request);
}
