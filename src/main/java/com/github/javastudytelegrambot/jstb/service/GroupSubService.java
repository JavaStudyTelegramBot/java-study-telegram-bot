package com.github.javastudytelegrambot.jstb.service;

import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupDiscussionInfo;
import com.github.javastudytelegrambot.jstb.repository.entity.GroupSub;
import org.springframework.stereotype.Service;

@Service
public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
