package com.cjpnice.word.service;

import com.cjpnice.word.entity.User;
import com.cjpnice.word.util.Result;


import java.util.Map;

public interface UserService {
    Result selectUserByNameAndPassword(String username,String password);
    Result addUser(User user);
    Result selectUserByName(String username);
    Result setWordNum(int wordNum,int userId);
    Result setTodayIsRecite(int userId);
}
