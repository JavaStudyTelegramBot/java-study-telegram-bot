package com.github.javastudytelegrambot.jstb.javarushclient;

import com.github.javastudytelegrambot.jstb.javarushclient.dto.*;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JavaRushGroupClientImpl implements JavaRushGroupClient {
    private final String javaRushGroupApiPath;
    private final String javaRushPostApiPath;

    public JavaRushGroupClientImpl(@Value("${javarush.api.path}") String javaRushApiPath){
        javaRushGroupApiPath = javaRushApiPath + "/groups";
        javaRushPostApiPath = javaRushApiPath + "/posts";
    }

    @Override
    public List<GroupInfo> getGroupList(GroupRequestArgs requestArgs) {
        return Unirest.get(javaRushGroupApiPath)
                .queryString(requestArgs.populateQueries())
                .asObject(new GenericType<List<GroupInfo>>() {})
                .getBody();
    }

    @Override
    public List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs) {
        return Unirest.get(javaRushGroupApiPath)
                .queryString(requestArgs.populateQueries())
                .asObject(new GenericType<List<GroupDiscussionInfo>>() {})
                .getBody();
    }

    @Override
    public Integer getGroupCount(GroupsCountRequestArgs countRequestArgs) {
        return Integer.valueOf(
                Unirest.get(String.format("%s/count", javaRushGroupApiPath))
                        .queryString(countRequestArgs.populateQueries())
                        .asString()
                        .getBody()
                );
    }

    @Override
    public GroupDiscussionInfo getGroupById(Integer id) {
        return Unirest.get(String.format("%s/group%s", javaRushGroupApiPath, id.toString()))
                .asObject(GroupDiscussionInfo.class)
                .getBody();
    }

    @Override
    public Integer findLastArticleId(Integer groupSubId) {
        List<PostInfo> posts = Unirest.get(javaRushPostApiPath)
                .queryString("order", "NEW")
                .queryString("groupKid", groupSubId.toString())
                .queryString("limit", "1")
                .asObject(new GenericType<List<PostInfo>>() {
                })
                .getBody();
        return posts.isEmpty() ? 0 : Optional.ofNullable(posts.get(0)).map(PostInfo::getId).orElse(0);
    }

}
