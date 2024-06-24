package com.example.kodtest.integration;

import com.example.kodtest.model.Comment;
import com.example.kodtest.model.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JsonPlaceHolderIntegrationClient {

    /**
     * No Http code or exception handling in this integration client.
     * Response.getBody could produce null-pointer if server returns null body
     * No injected url properties, could be made dynamic
     **/


    public Post updatePost(Post postRequest) {

        ResponseEntity<Post> response = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts")
                .build()
                .post()
                .bodyValue(postRequest)
                .retrieve()
                .toEntity(Post.class)
                .block();

        return response.getBody();
    }

    public Post[] getPosts(int userId) {

        ResponseEntity<Post[]> response = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts/?userId=" + userId)
                .build()
                .get()
                .retrieve()
                .toEntity(Post[].class)
                .block();

        return response.getBody();
    }

    public Comment[] getComments(int postId) {

        ResponseEntity<Comment[]> response = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts/" + postId + "/comments")
                .build()
                .get()
                .retrieve()
                .toEntity(Comment[].class)
                .block();

        return response.getBody();
    }
}
