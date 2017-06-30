package com.example.shikaibot.dao;

import com.example.shikaibot.entity.Speech;
import com.example.shikaibot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by naonaoakiaki on 2017/06/24.
 */
@Mapper
public interface SpeechMapper {
    //ユーザごとのspeech数
    @Select("SELECT USER_ID, count(*) as count FROM SPEECH GROUP BY USER_ID")
    List<Speech> selectAll();

}