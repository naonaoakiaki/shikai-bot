package com.example.shikaibot.service;

import com.example.shikaibot.dao.SpeechMapper;
import com.example.shikaibot.dao.UserMapper;
import com.example.shikaibot.entity.Speech;
import com.example.shikaibot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naonaoakiaki on 2017/07/08.
 */
@Component
public class SpeechService {

    @Autowired
    SpeechMapper speechMapper;

    @Autowired
    UserMapper userMapper;

    public String getTodayShikai() {

        //speech数の最小を求める
        Long minSpeechCount = Long.MAX_VALUE;
        List<Speech> speechs = speechMapper.selectAll();
        for (Speech speech : speechs) {
            if (minSpeechCount > speech.getCount()) {
                minSpeechCount = speech.getCount();
            }
        }

        //speech数が最小の人を求める
        List<User> minSpeakers = new ArrayList<User>();
        for (Speech speech : speechs) {
            if (minSpeechCount == speech.getCount()) {
                minSpeakers.add(userMapper.getUserName(speech.getUser_id()));
            }
        }

        //speech数が最小の人で一番年配の人を求める
        User oldUser = new User();
        oldUser.setBirthday("29991231");
        if (minSpeakers.size() == 1) {
            return minSpeakers.get(0).getName();
        } else {
            for (User user : minSpeakers) {
                if (Long.parseLong(oldUser.getBirthday()) > Long.parseLong(user.getBirthday())) {
                    oldUser.setBirthday(user.getBirthday());
                    oldUser.setName(user.getName());
                }
            }
            return oldUser.getName();
        }
    }
}
