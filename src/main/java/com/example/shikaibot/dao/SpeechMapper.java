package com.example.shikaibot.dao;

import com.example.shikaibot.entity.Speech;
import com.example.shikaibot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by naonaoakiaki on 2017/06/24.
 */
@Mapper
public interface SpeechMapper {
    //ユーザごとのspeech数
    @Select("SELECT u.USER_ID, c.count FROM USER as u " +
            "JOIN ( " +
            "  SELECT USER_ID, count(*) as count " +
            "  FROM SPEECH " +
            "  GROUP BY USER_ID " +
            ") as c ON u.USER_ID = c.USER_ID")
    List<Speech> selectAll();


//    @Insert("INSERT INTO SPEECH(USER_ID, SPEECH_DATE, DELETED) VALUES(#{user_id}, to_date(#{currentDate},'yyyy/mm/dd'), '0')")
    @Insert("INSERT INTO speech(USER_ID, SPEECH_DATE, DELETED) VALUES(#{user_id}, to_date('2006-4-27','yyyy/mm/dd'), '0')")
    void insertSpeech(String user_id, String currentDate);

}