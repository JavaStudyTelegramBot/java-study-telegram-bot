package com.github.javastudytelegrambot.jstb.repository;

import com.github.javastudytelegrambot.jstb.repository.entity.GroupSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSubRepository extends JpaRepository<GroupSub, Integer> {
}
