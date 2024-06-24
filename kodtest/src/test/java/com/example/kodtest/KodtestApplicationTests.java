package com.example.kodtest;

import com.example.kodtest.integration.JsonPlaceHolderIntegrationClient;
import com.example.kodtest.model.Comment;
import com.example.kodtest.model.Post;
import com.example.kodtest.service.LocalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class KodtestApplicationTests {
    @MockBean
    private JsonPlaceHolderIntegrationClient integrationClient;
    @Autowired
    private LocalService localService;


    @Test
    public void testGetCommentReturnsCorrectCommentForUser() {

        int userId = 0;
        Post mockedPost = Post.builder()
                .withBody("Mocked body")
                .withTitle("Mocked title")
                .withId(0)
                .withUserId(0)
                .build();
        Post[] mockedPosts = new Post[] {mockedPost};

        Comment mockedComment = Comment.builder()
                .withBody("Mocked body")
                .withEmail("Mocked@Email")
                .withName("name").withId(0)
                .withPostId(0).build();

        Comment[] mockedComments = new Comment[] {mockedComment};

        Mockito.when(integrationClient.getPosts(userId)).thenReturn(mockedPosts);
        Mockito.when(integrationClient.getComments(0)).thenReturn(mockedComments);

        Comment actual = localService.getComments(userId);

        Assertions.assertEquals(mockedComment, actual);

    }

}
