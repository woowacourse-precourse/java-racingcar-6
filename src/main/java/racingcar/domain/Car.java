package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int distance;
    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        this.distance += 1;
    }

    public void position() {
        System.out.println(this.name + " : " + "-".repeat(this.distance));
    }

    public int checkMaxDistance(int maxDistance) {
        return Math.max(this.distance, maxDistance);
    }

    public boolean compareMaxDistance(int maxDistance) {
        return this.distance == maxDistance;
    }

    public String getName() {
        return name;
    }
}
