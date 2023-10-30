package racingcar.model;

import static racingcar.util.RandomNumberGenerator.generateRandomNumber;

public class Car implements Comparable<Car> {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_SIZE = 1;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 1-5글자이어야 함";

    private final String name;
    private int distance;


    private Car(String name) {
        if (!validateNameLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
        this.name = name;
        this.distance = 0;
    }

    public static Car createNewCar(String name) {
        return new Car(name);
    }

    public void updateDistance() {
        if (generateRandomNumber() >= MOVE_THRESHOLD) {
            this.distance += MOVE_SIZE;
        }
    }

    private boolean validateNameLength(String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }

    public boolean isSameDistance(Car car) {
        return this.distance == car.distance;
    }
}
