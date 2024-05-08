package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;
import org.abhk943.models.enums.MatchingType;
import org.abhk943.services.interfaces.MatchingStrategy;

@Getter
@Setter
public class User {
    private Long id;
    private Long driverId;
    private String name;
    private Location location;
    private MatchingType matchingType;

    public User(){

    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
        this.location = null;
        this.matchingType = MatchingType.SHORTEST_DISTANCE;
    }

    public User(Long id, String name, MatchingType matchingType) {
        this.id = id;
        this.name = name;
        this.location = null;
        this.matchingType = matchingType;
    }
}
