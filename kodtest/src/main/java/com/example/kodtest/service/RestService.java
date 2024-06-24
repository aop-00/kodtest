package com.example.kodtest.service;

import com.example.kodtest.model.Comment;
import com.example.kodtest.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

    @Autowired
    private LocalService localService;

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public ResponseEntity<Post> createResource() {
        try {
            Post response = localService.post();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            //This could be a place to log errors
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(value = "/getComment/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Comment> getFilteredResource(@PathVariable int userId) {
        try {
            Comment response = localService.getComments(userId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            //This could be a place to log errors
            return ResponseEntity.internalServerError().build();
        }
    }
}
