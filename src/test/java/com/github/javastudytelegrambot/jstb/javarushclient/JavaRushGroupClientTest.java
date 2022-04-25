package com.github.javastudytelegrambot.jstb.javarushclient;

import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupDiscussionInfo;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupInfo;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupRequestArgs;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupsCountRequestArgs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupInfoType.TECH;

@DisplayName(value = "Integration-level testing for JavaRushGroupClientImplTest")
public class JavaRushGroupClientTest {
    private final JavaRushGroupClient javaRushGroupClient = new JavaRushGroupClientImpl("https://javarush.com.ua/api/1.0/rest");

    @Test
    @DisplayName(value = "Getting groups with empty arguments")
    public void shouldProperlyGetGroupsWithEmptyArgs() {
        GroupRequestArgs args = GroupRequestArgs.builder().build();

        List<GroupInfo> groupList = javaRushGroupClient.getGroupList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    @DisplayName(value = "Getting groups with offset = 1 and limit = 3 arguments")
    public void shouldProperlyGetWithOffSetAndLimit() {
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();

        List<GroupInfo> groupList = javaRushGroupClient.getGroupList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    @DisplayName(value = "Getting discussion groups with empty arguments")
    public void shouldProperlyGetGroupsDiscWithEmptyArgs() {
        GroupRequestArgs args = GroupRequestArgs.builder().build();

        List<GroupDiscussionInfo> groupList = javaRushGroupClient.getGroupDiscussionList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    @DisplayName(value = "Getting discussion groups with offset = 1 and limit = 3 arguments")
    public void shouldProperlyGetGroupDiscWithOffSetAndLimit() {
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();

        List<GroupDiscussionInfo> groupList = javaRushGroupClient.getGroupDiscussionList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    @DisplayName(value = "Getting group count")
    public void shouldProperlyGetGroupCount() {
        GroupsCountRequestArgs args = GroupsCountRequestArgs.builder().build();

        Integer groupCount = javaRushGroupClient.getGroupCount(args);

        Assertions.assertEquals(32, groupCount);
    }

    @Test
    @DisplayName(value = "Getting TECH group count")
    public void shouldProperlyGetGroupTECHCount() {
        GroupsCountRequestArgs args = GroupsCountRequestArgs.builder()
                .type(TECH)
                .build();

        Integer groupCount = javaRushGroupClient.getGroupCount(args);

        Assertions.assertEquals(7, groupCount);
    }

    @Test
    @DisplayName(value = "Getting group with ID = 16")
    public void shouldProperlyGetGroupById() {
        Integer androidGroupId = 16;

        GroupDiscussionInfo groupById = javaRushGroupClient.getGroupById(androidGroupId);

        Assertions.assertNotNull(groupById);
        Assertions.assertEquals(16, groupById.getId());
        Assertions.assertEquals(TECH, groupById.getType());
        Assertions.assertEquals("android", groupById.getKey());
    }

}
