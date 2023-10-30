package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int distance;


    public Player(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<String> printDistance(int distance) {
        List<String> returnList = new ArrayList<>();
        for(int i = 0; i < distance; i++) {
            returnList.add("-");
        }
        return returnList;
    }
}
