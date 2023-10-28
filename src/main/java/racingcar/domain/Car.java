package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    private String name;
    private Integer moveDistance;

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(1,9);
        if (randomValue >= 4) {
            this.moveDistance += 1;
        }
    }

    public boolean hasSameDistance(Car otherCar) {
        return this.moveDistance == otherCar.moveDistance;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.moveDistance - otherCar.moveDistance;
    }
}
