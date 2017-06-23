package com.example.shikaibot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by naonaoakiaki on 2017/06/24.
 */
@RestController
public class ShikaiController {
    private static final Logger log = LoggerFactory.getLogger(ShikaiController.class);


    @GetMapping(value = "/get")
    public HttpStatus getSpeaker() {
        return HttpStatus.OK;
    }

    @GetMapping(value = "/done")
    public HttpStatus doneSpeech(String userName) {
        log.info(userName);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/skip")
    public HttpStatus skipSpeaker(String userName) {
        log.info(userName);
        return HttpStatus.OK;
    }

}
