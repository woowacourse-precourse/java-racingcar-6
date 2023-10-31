package service;

import static util.Constant.GO_NUMBER;

public class Car{

    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go(int randomNumber){
        if (randomNumber >= GO_NUMBER) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
