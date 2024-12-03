package com.example.kodtest.model;

import lombok.*;

@Data
@Builder(setterPrefix = "with")
public class Comment {

    /**
     * Object used represent a comment
     */

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

}
