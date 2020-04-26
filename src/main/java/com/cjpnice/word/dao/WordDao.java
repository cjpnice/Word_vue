package com.cjpnice.word.dao;


import com.cjpnice.word.entity.Word;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordDao {
    int createNewTable(@Param("tableName") String tableName);
    List<Word> selectWord(@Param("tableName") String tableName,@Param("wordNum") int wordNum);
}
