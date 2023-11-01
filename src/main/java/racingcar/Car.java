package racingcar;

import static racingcar.RandomNumberRange.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car createCar(final String name, int distance) {
        return new Car(name, distance);
    }

    public void moveByGeneratedNumber() {
        Integer randomNumber = generateRandomNumber();

        if (isLargerThanStandard(randomNumber)) {
            distance++;
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANGE_VALUE.getValue(), MAXIMUM_RANGE_VALUE.getValue());
    }

    private boolean isLargerThanStandard(int randomNumber) {
        return STANDARD_VALUE.getValue() <= randomNumber;
    }

    public boolean isSameDistance(int maximumDistance) {
        return distance == maximumDistance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
