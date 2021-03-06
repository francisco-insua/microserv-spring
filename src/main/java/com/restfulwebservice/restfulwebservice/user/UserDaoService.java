package com.restfulwebservice.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>() ;
    private static int usersCount = 3;

    static {
        users.add(new User(1,"Adam", new Date()));
        users.add(new User(2,"Carlos", new Date()));
        users.add(new User(3,"Saul", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().
                filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    public User deleteById(int id) {
        User user = findOne(id);
        if (user != null) {
            users.removeIf(u -> u.getId() == id);
             return user;
        }
        return null;
    }



}
