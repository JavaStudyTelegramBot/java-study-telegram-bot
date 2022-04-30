package com.github.javastudytelegrambot.jstb.javarushclient;

import com.github.javastudytelegrambot.jstb.javarushclient.dto.PostInfo;

import java.util.List;

public interface JavaRushPostClient {
    List<PostInfo> findNewPosts(Integer groupId, Integer lastPostId);
}
