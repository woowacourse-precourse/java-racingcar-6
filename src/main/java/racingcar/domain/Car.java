package racingcar.domain;

import static racingcar.gameutil.GameConstants.*;

import racingcar.gameutil.GameConstants;
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

    public Car(String name, Integer moveDistance) {
        this.name = name;
        this.moveDistance = moveDistance;
    }

    public void move() {
        if (canMove()) {
            this.moveDistance += MOVE_DISTANCE;
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
        return getGenerateRandomNum() >= CAN_MOVE_MIN_VALUE;
    }

    private int getGenerateRandomNum() {
        return randomUtil.generate(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
    }
}
