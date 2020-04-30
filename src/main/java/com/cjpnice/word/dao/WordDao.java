package com.cjpnice.word.dao;


import com.cjpnice.word.entity.Word;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordDao {
    int createNewTable(@Param("tableName") String tableName);
    List<Word> getForgetWord(@Param("tableName") String tableName,@Param("wordNum") int wordNum);
    List<Word> getRememberWord(@Param("tableName") String tableName,@Param("wordNum") int wordNum);
    int setIsRemember(@Param("tableName") String tableName,@Param("id") int id);
    void setForgetTime(@Param("tableName") String tableName,@Param("time") int time,@Param("id") int id);
    void setReciteTime(@Param("tableName") String tableName,@Param("time") int time,@Param("id") int id);
    int selectForgetTime(@Param("tableName") String tableName,@Param("id") int id);
    int selectReciteTime(@Param("tableName") String tableName,@Param("id") int id);
    List<Word> selectForgetWord(@Param("tableName") String tableName);
}
