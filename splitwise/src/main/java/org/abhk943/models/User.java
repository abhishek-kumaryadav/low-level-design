package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;

    public User(Long id) {
        this.id = id;
    }
}
