package com.cjpnice.word.interceptor;



import com.alibaba.fastjson.JSONObject;
import com.cjpnice.word.constant.TokenConstant;
import com.cjpnice.word.util.TokenSign;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Component
public class LoginInterceptor implements HandlerInterceptor {


    //    在请求处理之前调用,只有返回true才会执行要执行的请求
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        httpServletResponse.setCharacterEncoding("UTF-8");
        String token=httpServletRequest.getHeader("Authorization");
        if (null==token){
            Map<String,Object> map=new HashMap<>();
            map.put("data","token is null");
            map.put("code","401");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(map));
            return false;
        }else {
            boolean result= TokenSign.verify(token);

            if (result){
                //更新存储的token信息
                TokenConstant.updateTokenMap(token);
                return true;
            }

            Map<String,Object> map=new HashMap<>();
            map.put("data","token is null");
            map.put("code","401");
            httpServletResponse.getWriter().write(JSONObject.toJSONString(map));
            return false;

        }


    }

    //    试图渲染之后执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //    在请求处理之后,视图渲染之前执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}

