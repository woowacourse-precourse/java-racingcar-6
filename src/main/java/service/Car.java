package service;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int GO_NUMBER = 4;
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go(){
        if (Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= GO_NUMBER) {
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
