package com.example.shchenev.sber.model;

import com.example.shchenev.sber.Entity.UserEntity;

public class User {
    private Long id;
    private String userName;

    public User() {
    }


    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getUser_id());
        model.setUserName(entity.getUser_login());
        return model;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
