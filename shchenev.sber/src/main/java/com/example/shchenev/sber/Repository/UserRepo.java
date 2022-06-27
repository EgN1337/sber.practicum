package com.example.shchenev.sber.Repository;

import com.example.shchenev.sber.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
        UserEntity findUserByUserName(String user_login);
}
