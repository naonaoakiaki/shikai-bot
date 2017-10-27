package com.example.shikaibot.service;

import com.example.shikaibot.entity.SlackPayload;
import com.example.shikaibot.properties.ShikaiProperties;
import com.example.shikaibot.properties.SlackProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by naonaoakiaki on 2017/10/27.
 */
@Service
public class SlackService {

    @Autowired
    SlackProperties slackProperties;

    @Autowired
    ShikaiProperties shikaiProperties;

    private static final Logger logger = LoggerFactory.getLogger(SlackService.class);

    public HttpStatus postSlack(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String message = messageBuilder(shikaiProperties.getUrl(), name);
        SlackPayload slackPayload = new SlackPayload("#shikai_bot", "webhookbot", message, ":ghost:");
        RequestEntity<SlackPayload> requestEntity = RequestEntity.post(slackProperties.getUrl()).body(slackPayload);
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        return responseEntity.getStatusCode();
    }

    private String messageBuilder(String url, String name) {
        StringBuilder message = new StringBuilder();
        message.append(name);
        message.append(" ");
        message.append(url);
        message.append("get ");
        message.append(url);
        message.append("done ");
        message.append(url);
        message.append("skip ");
        return message.toString();
    }
}