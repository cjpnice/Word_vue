package com.cjpnice.word.controller;


import com.cjpnice.word.service.WordService;
import com.cjpnice.word.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/api/word")
public class WordController {
    @Resource
    WordService wordService;
    @RequestMapping(value = "/getWord",method= RequestMethod.POST)
    @ResponseBody
    public Result getWord(int userId, int wordNum){
        Result result = new Result();
        String tableName = "wordList"+userId;
        result = wordService.selectWord(tableName,wordNum);
        return result;
    }
    @RequestMapping(value = "/setIsRemember",method= RequestMethod.POST)
    @ResponseBody
    public Result setIsRemember(int userId, int id){
        Result result = new Result();
        String tableName = "wordList"+userId;
        result = wordService.setIsRemember(tableName,id);
        return result;
    }
    @RequestMapping(value = "/setForgetTime",method= RequestMethod.POST)
    @ResponseBody
    public Result setForgetTime(int userId, int id){
        Result result = new Result();
        String tableName = "wordList"+userId;
        int time = (int) wordService.selectForgetTime(tableName,id).getData()+1;
        result = wordService.setForgetTime(tableName,time,id);
        return result;
    }
    @RequestMapping(value = "/getForgetWord",method= RequestMethod.POST)
    @ResponseBody
    public Result getForgetWord(int userId){
        Result result = new Result();
        String tableName = "wordList"+userId;
        result = wordService.selectForgetWord(tableName);
        return result;
    }
}
