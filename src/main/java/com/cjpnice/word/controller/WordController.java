package com.cjpnice.word.controller;


import com.cjpnice.word.entity.Word;
import com.cjpnice.word.service.WordService;
import com.cjpnice.word.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/api/word")
public class WordController {
    @Resource
    WordService wordService;
    @RequestMapping(value = "/getWord",method= RequestMethod.POST)
    @ResponseBody
    public Result getWord(int userId, int wordNum, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Result result = new Result();
        List<Word> wordList = new ArrayList<>();
        String tableName = "wordList"+userId;
        int forgetWordNum = wordNum/2;
        int rememberWordNum = wordNum-wordNum/2;

        List<Word> rememberWordlist = (List<Word>) wordService.getRememberWord(tableName,rememberWordNum).getData();
        //防止刚开始记住的单词太少，查询不到，所以如果查询的数量少于一半，则再次插叙不会的填充进list
        if(rememberWordlist.size()<rememberWordNum){
            List<Word> forgetWordlist = (List<Word>) wordService.getForgetWord(tableName, wordNum-rememberWordlist.size()).getData();
            wordList.addAll(rememberWordlist);
            wordList.addAll(forgetWordlist);
        }else{
            List<Word> forgetWordlist = (List<Word>) wordService.getForgetWord(tableName, forgetWordNum).getData();
            wordList.addAll(rememberWordlist);
            wordList.addAll(forgetWordlist);
        }
        //打乱单词顺序
        Collections.shuffle(wordList);
        result.setData(wordList);
        return result;
    }
    @RequestMapping(value = "/setIsRemember",method= RequestMethod.POST)
    @ResponseBody
    public Result setIsRemember(int userId, int id, HttpServletResponse resp){
        Result result = new Result();
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String tableName = "wordList"+userId;
        result = wordService.setIsRemember(tableName,id);
        return result;
    }
    @RequestMapping(value = "/setForgetTime",method= RequestMethod.POST)
    @ResponseBody
    public Result setForgetTime(int userId, int id, HttpServletResponse resp){
        Result result = new Result();
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String tableName = "wordList"+userId;
        int time = (int) wordService.selectForgetTime(tableName,id).getData()+1;
        result = wordService.setForgetTime(tableName,time,id);
        return result;
    }
    @RequestMapping(value = "/setReciteTime",method= RequestMethod.POST)
    @ResponseBody
    public Result setReciteTime(int userId, int id, HttpServletResponse resp){
        Result result = new Result();
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String tableName = "wordList"+userId;
        int time = (int) wordService.selectReciteTime(tableName,id).getData()+1;
        result = wordService.setReciteTime(tableName,time,id);
        return result;
    }
    @RequestMapping(value = "/getForgetWord",method= RequestMethod.POST)
    @ResponseBody
    public Result getForgetWord(int userId, HttpServletResponse resp){
        Result result = new Result();
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String tableName = "wordList"+userId;
        result = wordService.selectForgetWord(tableName);
        return result;
    }
}
