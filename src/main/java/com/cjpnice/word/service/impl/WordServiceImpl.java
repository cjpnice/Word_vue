package com.cjpnice.word.service.impl;

import com.cjpnice.word.dao.WordDao;
import com.cjpnice.word.entity.Word;
import com.cjpnice.word.service.WordService;
import com.cjpnice.word.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cjpnice
 */
@Service
public class WordServiceImpl implements WordService {
    @Resource
    WordDao wordDao;
    @Override
    public Result createNewTable(String tableName) {
        Result result = new Result();
        int status = wordDao.createNewTable(tableName);
        if(status==1){
            result.setMsg("建表成功");
            result.setStatus(0);
        }else{
            result.setMsg("建表失败");
            result.setStatus(1);
        }
        return result;
    }

    @Override
    public Result getForgetWord(String tableName, int wordNum) {
        Result result = new Result();
        List<Word> wordList = wordDao.getForgetWord(tableName,wordNum);
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(wordList);
        return result;

    }

    @Override
    public Result getRememberWord(String tableName, int wordNum) {
        Result result = new Result();
        List<Word> wordList = wordDao.getRememberWord(tableName,wordNum);
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(wordList);
        return result;

    }
    @Override
    public Result setIsRemember(String tableName, int id) {
        Result result = new Result();
        wordDao.setIsRemember(tableName,id);
        result.setMsg("更新成功");
        result.setStatus(0);
        return result;
    }

    @Override
    public Result selectForgetTime(String tableName, int id) {
        Result result = new Result();
        int time = wordDao.selectForgetTime(tableName,id);
        result.setData(time);
        result.setMsg("查询成功");
        result.setStatus(0);
        return result;
    }
    @Override
    public Result selectReciteTime(String tableName, int id) {
        Result result = new Result();
        int time = wordDao.selectReciteTime(tableName,id);
        result.setData(time);
        result.setMsg("查询成功");
        result.setStatus(0);
        return result;
    }


    @Override
    public Result setForgetTime(String tableName, int time, int id) {
        Result result = new Result();
        wordDao.setForgetTime(tableName,time,id);
        result.setMsg("更新成功");
        result.setStatus(0);
        return result;
    }
    @Override
    public Result setReciteTime(String tableName, int time, int id) {
        Result result = new Result();
        wordDao.setReciteTime(tableName,time,id);
        result.setMsg("更新成功");
        result.setStatus(0);
        return result;
    }

    @Override
    public Result selectForgetWord(String tableName) {
        Result result = new Result();
        List<Word> wordList = wordDao.selectForgetWord(tableName);
        result.setStatus(0);
        result.setMsg("查询成功");
        result.setData(wordList);
        return result;
    }




}
