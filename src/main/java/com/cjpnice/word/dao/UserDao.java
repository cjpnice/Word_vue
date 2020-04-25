package com.cjpnice.word.dao;

import com.cjpnice.word.entity.User;

public interface UserDao {
    User selectUserByNameAndPassword(String username,String password);
    int addUser(User user);
    User selectUserByName(String username);
}
