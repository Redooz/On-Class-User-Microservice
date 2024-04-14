package com.redoz.onclassuser.infrastructure.driven.jpa.mysql.repository;

import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String>{
    Optional<UserEntity> findByEmail(String email);
}
