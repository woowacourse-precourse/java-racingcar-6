package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int mileage;

    public Car(String name) {
        this.name = name;
        mileage = 0;
    }

    public void moveForward() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            ++mileage;
        }
    }

    @Override
    public int compareTo(Car car) {
        return this.mileage - car.getMileage();
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }
}
