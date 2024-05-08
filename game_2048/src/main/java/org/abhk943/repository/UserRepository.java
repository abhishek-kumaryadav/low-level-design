package org.abhk943.repository;

import org.abhk943.models.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepository {
    private static UserRepository userRepository;
    private Map<Long, User> userIdToUserMap;

    private UserRepository (){
        userIdToUserMap = new HashMap<>();
    }

    public void saveUser(User user){
        userIdToUserMap.putIfAbsent(user.getId(), user);
    }

    public User getUser(Long id){
        return userIdToUserMap.get(id);
    }

    public List<User> getUsers(){
        return new ArrayList<>(userIdToUserMap.values());
    }

    public static UserRepository getInstance(){
        if (Objects.isNull(userRepository)){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public void updateUser(Long id, User user) {
        userIdToUserMap.put(id, user);
    }
}
