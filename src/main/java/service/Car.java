package service;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{

    private static final int GO_NUMBER = 4;
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
