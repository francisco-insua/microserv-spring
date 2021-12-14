package com.restfulwebservice.restfulwebservice.post;

import com.restfulwebservice.restfulwebservice.exception.PostNotFoundException;
import com.restfulwebservice.restfulwebservice.exception.UserNotFoundException;
import com.restfulwebservice.restfulwebservice.exception.UserWithNoPostsException;
import com.restfulwebservice.restfulwebservice.post.PostDaoService;
import com.restfulwebservice.restfulwebservice.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService service;

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> retrieveAllPostsFromUser(@PathVariable int id) {
        List<Post> posts = service.findAllFromUser(id);
        if (posts.size() == 0) {
            throw new UserWithNoPostsException("No posts for the userId - " + id);
        }
        return posts;
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable int id) {
        Post savedPost = service.save(post, id);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/users/{id}/posts/{post_id}")
    public Post retrieveOnePostFromUser(@PathVariable int id, @PathVariable int post_id) {
        Post post = service.findOneFromUser(id, post_id);
        if (post == null) {
            throw new PostNotFoundException("No post for the userId - " + id);
        }
        return post;
    }

}
