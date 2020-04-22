package com.cjpnice.word.dao;

import com.cjpnice.word.entity.User;

public interface UserDao {
    public User selectUserByNameAndPassword(String username,String password);
}
