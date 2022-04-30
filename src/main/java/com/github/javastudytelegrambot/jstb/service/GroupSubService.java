package com.github.javastudytelegrambot.jstb.service;

import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupDiscussionInfo;
import com.github.javastudytelegrambot.jstb.repository.entity.GroupSub;

import java.util.List;
import java.util.Optional;

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);
    Optional<GroupSub> findById(Integer id);
    List<GroupSub> findAll();
}
