package org.abhk943.services;

import org.abhk943.interfaces.UserInterface;
import org.abhk943.models.User;
import org.abhk943.repository.UserRepository;

import java.util.List;

public class UserService implements UserInterface {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override public Long register(String name) {
        List<User> userList = userRepository.getUsers();
        Long userId = 1L;
        if (!userList.isEmpty())
            userId = (long) userList.size() + 1;
        userRepository.saveUser(new User(userId, name, 0L, null));
        return userId;
    }

    @Override public String getName(Long userId) {
        return userRepository.getUser(userId).getName();
    }
}
