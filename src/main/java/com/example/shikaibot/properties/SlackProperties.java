package com.example.shikaibot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * Created by naonaoakiaki on 2017/10/27.
 */
@Component
@ConfigurationProperties(prefix="slack")
@Data
public class SlackProperties {
    private URI url;
}