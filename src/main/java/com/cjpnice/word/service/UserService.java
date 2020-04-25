package com.cjpnice.word.service;

import com.cjpnice.word.entity.User;
import com.cjpnice.word.util.Result;


import java.util.Map;

public interface UserService {
    public Result selectUserByNameAndPassword(String username,String password);
    public Result addUser(User user);
    public Result selectUserByName(String username);
}
