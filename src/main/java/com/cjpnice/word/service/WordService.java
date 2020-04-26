package com.cjpnice.word.service;

import com.cjpnice.word.util.Result;

public interface WordService {
    Result createNewTable(String tableName);
    Result selectWord(String tableName,int wordNum);
}
