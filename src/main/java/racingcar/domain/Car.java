package racingcar.domain;

import racingcar.system.SystemConstant;

public class Car implements Comparable<Car>{

    private final String name;

    private int totalMovedDistance;

    public Car(String name) {
        this.name = name;
        this.totalMovedDistance = 0;
    }

    public void move() {
        int randomValue = RandomNumberGenerator.randomNumGenerate();
        if(randomValue >= SystemConstant.MIN_MOVE_THRESHOLD)
            totalMovedDistance++;
    }

    public String getName() {
        return name;
    }

    public int getTotalMovedDistance() {
        return totalMovedDistance;
    }

    @Override
    public int compareTo(Car other) {
        return this.totalMovedDistance - other.totalMovedDistance;
    }

    public boolean isSamePosition(Car other){
        return this.totalMovedDistance ==  other.totalMovedDistance;
    }
}
