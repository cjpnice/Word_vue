package com.cjpnice.word.service.impl;

import com.cjpnice.word.dao.UserDao;
import com.cjpnice.word.entity.User;
import com.cjpnice.word.service.UserService;
import com.cjpnice.word.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Override
    public Result selectUserByNameAndPassword(String username, String password) {
        Result result = new Result();
        User user = userDao.selectUserByNameAndPassword(username,password);
        if(user!=null){
            result.setMsg("查询成功");
            result.setStatus(0);
            result.setData(user);
        }else{
            result.setMsg("不存在该用户或账号密码不匹配");
            result.setStatus(1);
            result.setData(user);
        }
        return result;
    }

    @Override
    public Result addUser(User user) {
        Result result = new Result();
        try {
            int status = userDao.addUser(user);
            if(status==1){
                result.setMsg("新增成功");
                result.setStatus(0);
                result.setData(user);
            }else{
                result.setMsg("新增失败");
                result.setStatus(1);
                result.setData(null);
            }

        }catch (Exception e){
            result.setMsg("新增失败");
            result.setStatus(1);
            result.setData(null);
        }
        return result;
    }

    @Override
    public Result selectUserByName(String username) {
        Result result = new Result();
        User user = userDao.selectUserByName(username);
        if (user != null) {
            result.setMsg("查询成功");
            result.setStatus(0);
            result.setData(user);
        } else {
            result.setMsg("不存在该用户");
            result.setStatus(1);
            result.setData(user);
        }
        return result;
    }
}
