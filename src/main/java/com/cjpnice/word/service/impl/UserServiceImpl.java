package com.cjpnice.word.service.impl;

import com.cjpnice.word.dao.UserDao;
import com.cjpnice.word.entity.User;
import com.cjpnice.word.service.UserService;
import com.cjpnice.word.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Override
    public Result SelectUserByNameAndPassword(String username, String password) {
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
}
