package com.cjpnice.word.controller;

import com.cjpnice.word.entity.User;
import com.cjpnice.word.service.UserService;
import com.cjpnice.word.util.Result;
import okio.ByteString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;



@Controller
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    @ResponseBody
    public Result login(String username, String password){
        ByteString passwordByteString = ByteString.encodeUtf8(password);
        String passwordMd5 = passwordByteString.md5().hex();
        Result result = userService.SelectUserByNameAndPassword(username,passwordMd5);
        if(result.getStatus()==0){
            result.setMsg("登陆成功");
        }else{
            result.setMsg("登陆失败");
        }
        return result;
    }

    @RequestMapping(value = "/register",method= RequestMethod.POST)
    @ResponseBody
    public Result register(String username,String password,String email){
        User user = new User();
        ByteString passwordByteString = ByteString.encodeUtf8(password);
        String passwordMd5 = passwordByteString.md5().hex();
        user.setUsername(username);
        user.setPassword(passwordMd5);
        user.setEmail(email);
        user.setTodayIsRecite(0);
        Result result = userService.addUser(user);
        if(result.getStatus()==0){
            result.setMsg("注册成功");
        }else{
            result.setMsg("注册失败");
        }
        return result;
    }

}
