package com.example.kodtest.model;

import lombok.*;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ToString
@EqualsAndHashCode
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
