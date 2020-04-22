package com.cjpnice.word.service;

import com.cjpnice.word.util.Result;

import java.util.Map;

public interface UserService {
    public Result SelectUserByNameAndPassword(String username,String password);
}
