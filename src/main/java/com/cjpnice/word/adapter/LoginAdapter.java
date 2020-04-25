package com.cjpnice.word.adapter;



import com.cjpnice.word.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LoginAdapter implements WebMvcConfigurer {


    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("Content-Type","X-Requested-With","accept,Origin","Access-Control-Request-Method","Access-Control-Request-Headers","token")
                .allowedMethods("*")
                .allowedOrigins("*")
//是否允许使用cookie
                .allowCredentials(true);
    }




    @Autowired
    private LoginInterceptor loginInterceptor;


    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }



    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("进入拦截器");
        //addPathPatterns是表明拦截哪些请求
        //excludePathPatterns是对哪些请求不做拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login");
    }

}

