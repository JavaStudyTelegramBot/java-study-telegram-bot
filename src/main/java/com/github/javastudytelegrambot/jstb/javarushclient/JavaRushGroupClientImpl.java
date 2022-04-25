package com.github.javastudytelegrambot.jstb.javarushclient;

import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupDiscussionInfo;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupInfo;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupRequestArgs;
import com.github.javastudytelegrambot.jstb.javarushclient.dto.GroupsCountRequestArgs;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class JavaRushGroupClientImpl implements JavaRushGroupClient {
    private final String javarushGroupApiPath;

    public JavaRushGroupClientImpl(@Value("${javarush.api.path}") String javarushApiPath){
        javarushGroupApiPath = javarushApiPath + "/groups";
    }

    @Override
    public List<GroupInfo> getGroupList(GroupRequestArgs requestArgs) {
        return Unirest.get(javarushGroupApiPath)
                .queryString(requestArgs.populateQueries())
                .asObject(new GenericType<List<GroupInfo>>() {})
                .getBody();
    }

    @Override
    public List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs) {
        return Unirest.get(javarushGroupApiPath)
                .queryString(requestArgs.populateQueries())
                .asObject(new GenericType<List<GroupDiscussionInfo>>() {})
                .getBody();
    }

    @Override
    public Integer getGroupCount(GroupsCountRequestArgs countRequestArgs) {
        return Integer.valueOf(
                Unirest.get(String.format("%s/count", javarushGroupApiPath))
                        .queryString(countRequestArgs.populateQueries())
                        .asString()
                        .getBody()
                );
    }

    @Override
    public GroupDiscussionInfo getGroupById(Integer id) {
        return Unirest.get(String.format("%s/group%s", javarushGroupApiPath, id.toString()))
                .asObject(GroupDiscussionInfo.class)
                .getBody();
    }

}
