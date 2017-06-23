package com.example.shikaibot.dao;

import com.example.shikaibot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by naonaoakiaki on 2017/06/24.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT USER_ID, NAME, BIRTHDAY, DELETED FROM USER WHERE NAME = #{name}")
    User select(String name);

}