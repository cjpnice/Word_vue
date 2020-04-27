package com.cjpnice.word.dao;

import com.cjpnice.word.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User selectUserByNameAndPassword(String username,String password);
    int addUser(User user);
    User selectUserByName(String username);
    int setWordNum(@Param("wordNum") int wordNum,@Param("userId") int userId);
    void setTodayIsRecite(int userId);
}
