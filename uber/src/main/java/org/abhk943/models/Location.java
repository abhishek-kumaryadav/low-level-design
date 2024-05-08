package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Location {
    private Double x;
    private Double y;

    public Location(){
        Random rand = new Random();
        this.x = (double) rand.nextInt(1000);
        this.y = (double) rand.nextInt(1000);
    }
}
