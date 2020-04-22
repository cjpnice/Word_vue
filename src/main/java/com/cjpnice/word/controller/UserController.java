package com.cjpnice.word.controller;

import com.cjpnice.word.service.UserService;
import com.cjpnice.word.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    @ResponseBody
    public Result Login(String username, String password){
        Result result = userService.SelectUserByNameAndPassword(username,password);
        if(result.getStatus()==0){
            result.setMsg("登陆成功");
        }else{
            result.setMsg("登陆失败");
        }
        return result;
    }
}
