package com.example.shikaibot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

/**
 * Created by naonaoakiaki on 2017/10/27.
 */
@AllArgsConstructor
public class SlackPayload{
    @JsonProperty
    private String channel;
    @JsonProperty
    private String username;
    @JsonProperty
    private String text;
    @JsonProperty
    private String icon_emoji;
}