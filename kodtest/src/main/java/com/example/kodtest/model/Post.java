package com.example.kodtest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Post {

    /**
     * Object used represent a post
     */

    private int id;
    private String title;
    private String body;
    private int userId;
}
