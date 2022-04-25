package com.github.javastudytelegrambot.jstb.service;

import com.github.javastudytelegrambot.jstb.repository.entity.TelegramUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TelegramUserService {
    void save(TelegramUser telegramUser);

    List<TelegramUser> retrieveAllActiveUsers();

    Optional<TelegramUser> findByChatId(String chatId);
}
