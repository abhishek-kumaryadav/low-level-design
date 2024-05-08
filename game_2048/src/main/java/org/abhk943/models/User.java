package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;
import org.abhk943.interfaces.UserInterface;
import org.abhk943.repository.UserRepository;

import java.util.Random;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private Long highScore;
    private Long lastGameId;

    public User(Long id, String name, Long highScore, Long lastGameId) {
        this.id = id;
        this.name = name;
        this.highScore = highScore;
        this.lastGameId = lastGameId;
    }
}
