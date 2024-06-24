package com.example.kodtest.service;

import com.example.kodtest.model.Comment;
import com.example.kodtest.model.Post;
import com.example.kodtest.integration.JsonPlaceHolderIntegrationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalService {

    @Autowired
    private JsonPlaceHolderIntegrationClient integrationClient;

    public Post post() {
        Post postRequest = createUpdatePostRequest();
        return integrationClient.updatePost(postRequest);

    }

    public Comment getComments(int userId) {

        //Fetch all posts of the requested user
        Post[] response = integrationClient.getPosts(userId);

        //No check for content of list or object, could produce exception
        int firstPostId = response[0].getId();

        //Fetch comments (nestled objects) of the first post of the requested user. Ability to select specific comment is not possible
        Comment[] comments = integrationClient.getComments(firstPostId);

        //Return a single comment (nestled resource) from the list of comments for the post
        //No check for content of list, could produce exception
        return comments[0];


    }

    private Post createUpdatePostRequest() {

        //Hardcoded request, could be a request body made by user
        return Post.builder()
                .withTitle("Hej")
                .withBody("SEB")
                .withUserId(1)
                .build();
    }
}
