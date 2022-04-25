package com.github.javastudytelegrambot.jstb.javarushclient.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupDiscussionInfo extends GroupInfo {
    private Integer commentsCount;
    private UserDiscussionInfo userDiscussionInfo;
}
