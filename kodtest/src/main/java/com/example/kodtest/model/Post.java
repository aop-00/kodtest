package com.example.kodtest.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Post {

    /**
     * Object used to represent a post
     */

    private int id;
    private String title;
    private String body;
    private int userId;
}
