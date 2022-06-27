package com.example.shchenev.sber.service;

import com.example.shchenev.sber.Entity.UserEntity;
import com.example.shchenev.sber.Repository.UserRepo;
import com.example.shchenev.sber.exception.UserAlreadyExistException;
import com.example.shchenev.sber.exception.UserNotFoundException;
import com.example.shchenev.sber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepo.findUserByUserName(userEntity.getUser_login()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(userEntity);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }
}
