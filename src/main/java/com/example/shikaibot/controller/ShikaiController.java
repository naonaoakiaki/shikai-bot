package com.example.shikaibot.controller;

import com.example.shikaibot.dao.SpeechMapper;
import com.example.shikaibot.dao.UserMapper;
import com.example.shikaibot.entity.Speech;
import com.example.shikaibot.entity.User;
import com.example.shikaibot.service.SlackService;
import com.example.shikaibot.service.SpeechService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by naonaoakiaki on 2017/06/24.
 */
@RestController
public class ShikaiController {
    private static final Logger log = LoggerFactory.getLogger(ShikaiController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SpeechMapper speechMapper;

    @Autowired
    private SpeechService speechService;

    @Autowired
    private SlackService slackService;

    @GetMapping(value = "/get")
    public HttpStatus getSpeaker() {
         slackService.postSlack(speechService.getTodayShikai());
         return HttpStatus.OK;
    }

    @GetMapping(value = "/getAll")
    public List<User> getAllSpeakers() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @GetMapping(value = "/getSpeechs")
    public List<Speech> getSpeechs() {
        List<Speech> speechs = speechMapper.selectAll();
        log.info(speechs.toString());
        return speechs;
    }

    @GetMapping(value = "/done")
    public HttpStatus doneSpeech(String userName) {
        log.info(userName);
        speechService.doneTodayShikai(userName);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/skip")
    public HttpStatus skipSpeaker(String userName) {
        log.info(userName);
        return HttpStatus.OK;
    }

}
