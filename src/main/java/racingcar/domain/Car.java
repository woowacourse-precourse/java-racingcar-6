package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    private String name;
    private Integer moveDistance;

    public Car(String name, Integer moveDistance) {
        this.name = name;
        this.moveDistance = moveDistance;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0,9);
        if (randomValue >= 4) {
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
}
