package com.cjpnice.word.controller;

import com.cjpnice.word.entity.User;
import com.cjpnice.word.service.UserService;
import com.cjpnice.word.util.Result;
import com.cjpnice.word.util.TokenSign;
import okio.ByteString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    @ResponseBody
    public Result login(String username, String password, HttpServletRequest request){
//        String requestToken = request.getHeader("Authorization");
//        if(requestToken!=null){
//            boolean result = TokenSign.verify(requestToken);
//            if(result){
//                //Token正确且没有失效
//
//            }else{
//                //Token错误或失效
//
//            }
//        }

        ByteString passwordByteString = ByteString.encodeUtf8(password);
        String passwordMd5 = passwordByteString.md5().hex();
        Result result = userService.selectUserByNameAndPassword(username,passwordMd5);
        if(result.getStatus()==0){
            String token = TokenSign.sign(username,password);
            result.setMsg("登陆成功");
            result.setData(token);
        }else{
            result.setMsg("登陆失败");
        }
        return result;
    }

    @RequestMapping(value = "/register",method= RequestMethod.POST)
    @ResponseBody
    public Result register(String username,String password,String email){
        Result result = new Result();
        User oldUser = (User) userService.selectUserByName(username).getData();
        //判断用户名是否已经存在
        if(oldUser == null){
            User user = new User();
            ByteString passwordByteString = ByteString.encodeUtf8(password);
            String passwordMd5 = passwordByteString.md5().hex();
            user.setUsername(username);
            user.setPassword(passwordMd5);
            user.setEmail(email);
            user.setTodayIsRecite(0);
            result = userService.addUser(user);
            if(result.getStatus()==0){
                result.setMsg("注册成功");
            }else{
                result.setMsg("注册失败");
            }
        }else{
            result.setMsg("该用户名已经存在");
            result.setStatus(1);
        }
        return result;
    }

}
