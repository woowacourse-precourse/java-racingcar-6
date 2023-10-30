package racingcar.domain;

import racingcar.util.RandomUtil;

public class Car implements Comparable<Car>{

    private RandomUtil randomUtil;
    private String name;
    private Integer moveDistance;

    public Car(String name, Integer moveDistance, RandomUtil randomUtil) {
        this.name = name;
        this.moveDistance = moveDistance;
        this.randomUtil = randomUtil;
    }

    public void move() {
        if (canMove()) {
            this.moveDistance += 1;
        }
    }

    public String showDistance() {
        String distance = "";
        for (int count = 0; count < moveDistance; count++) {
            distance += "-";
        }
        return distance;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasSameDistance(Car otherCar) {
        return this.moveDistance == otherCar.moveDistance;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.moveDistance - otherCar.moveDistance;
    }

    private boolean canMove() {
        return getGenerateRandomNum() >= 4;
    }

    private int getGenerateRandomNum() {
        return randomUtil.generate(0, 9);
    }
}
