package model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
public class Car {
    private String name;
    private int distance = 0;
    private final int MIN_NUM = 0;
    private final int MAX_NUM = 9;

    Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if(canGoFoward()) {
            this.distance += 1;
        }
    }

    public String getName() {
        return this.name;
    }
    public int getDistance() {
        return this.distance;
    }

    private boolean canGoFoward() {
        return pickNumberInRange(MIN_NUM,MAX_NUM) >= 4;
    }
}
