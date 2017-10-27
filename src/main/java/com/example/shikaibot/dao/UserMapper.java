package com.example.shikaibot.dao;

import com.example.shikaibot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by naonaoakiaki on 2017/06/24.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT USER_ID, NAME, BIRTHDAY, DELETED FROM USER WHERE NAME = #{name}")
    User getUser(String name);

    @Select("SELECT USER_ID, NAME, BIRTHDAY, DELETED FROM USER WHERE USER_ID = #{user_id}")
    User getUserName(String user_id);

    @Select("SELECT USER_ID, NAME, BIRTHDAY, DELETED FROM USER")
    List<User> selectAll();
}