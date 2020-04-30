package com.cjpnice.word.service;

import com.cjpnice.word.util.Result;

public interface WordService {
    Result createNewTable(String tableName);
    Result getForgetWord(String tableName,int wordNum);
    Result getRememberWord(String tableName,int wordNum);
    Result setIsRemember(String tableName,int id);
    Result selectForgetTime(String tableName,int id);
    Result selectReciteTime(String tableName,int id);
    Result setForgetTime(String tableName,int time,int id);
    Result setReciteTime(String tableName,int time,int id);
    Result selectForgetWord(String tableName);


}
