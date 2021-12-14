package com.restfulwebservice.restfulwebservice.post;

import com.restfulwebservice.restfulwebservice.exception.UserNotFoundException;
import com.restfulwebservice.restfulwebservice.user.UserDaoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostDaoService {

    private static List<Post> posts = new ArrayList<>() ;
    private static int postsCount = 3;
    private UserDaoService service = new UserDaoService();

    static {
        posts.add(new Post(1, 1, new Date()));
        posts.add(new Post(2, 1, new Date()));
        posts.add(new Post(3, 2, new Date()));
    }

    public List<Post> findAllFromUser(int id) {
        return posts.stream()
                .filter(post -> post.getUserId() == id)
                .collect(Collectors.toList());
    }

    public Post save(Post post, int id) {
        if (service.findOne(id) == null) {
            throw new UserNotFoundException("User not found id: " + id);
        }

        if (post.getId() == null) {
            post.setId(++postsCount);
        }

        post.setUserId(id);
        posts.add(post);
        return post;
    }

    public Post findOneFromUser(int id, int post_id) {
        return posts.stream()
                .filter(post -> post.getUserId() == id && post.getId() == post_id)
                .findAny()
                .orElse(null);
    }
}
