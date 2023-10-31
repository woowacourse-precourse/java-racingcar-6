package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int randomNumber;
    String distanceLine;
    int distance;

    public Player(String name) {
        this.name = name;
        this.randomNumber = 0;
        this.distanceLine = "";
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getDistanceLine() {
        if(this.randomNumber >= 4)
            distanceLine = distanceLine + "-";
            distance++;
        return distanceLine;
    }

    public int getDistance() {
        return distance;
    }
}
