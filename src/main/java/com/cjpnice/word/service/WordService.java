package com.cjpnice.word.service;

import com.cjpnice.word.util.Result;

public interface WordService {
    Result createNewTable(String tableName);
    Result selectWord(String tableName,int wordNum);
    Result setIsRemember(String tableName,int id);
    Result selectForgetTime(String tableName,int id);
    Result setForgetTime(String tableName,int time,int id);
    Result selectForgetWord(String tableName);
}
