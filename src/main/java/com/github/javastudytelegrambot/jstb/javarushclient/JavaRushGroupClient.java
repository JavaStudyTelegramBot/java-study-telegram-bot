package com.github.javastudytelegrambot.jstb.javarushclient;

import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupDiscussionInfo;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupInfo;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupRequestArgs;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupsCountRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {
    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);

    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);

    Integer getGroupCount(GroupsCountRequestArgs countRequestArgs);

    GroupDiscussionInfo getGroupById(Integer id);


    Integer findLastArticleId(Integer groupSubId);
}
