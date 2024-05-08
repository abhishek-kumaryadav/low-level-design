package org.abhk943.repositories;

import org.abhk943.models.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepository {

    private static UserRepository userRepository;
    private Map<Long, User> userMap;
    private UserRepository(){
        this.userMap = new HashMap<>();
    }

    public static UserRepository getInstance(){
        if(Objects.isNull(userRepository)){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public User getUser(Long id){
        return userMap.get(id);
    }

    public List<User> getUsers(){
        return new ArrayList<>(this.userMap.values());
    }

    public void addUser(Long id, String name){
        User user = new User(id, name);
        userMap.putIfAbsent(id, user);
    }
}
