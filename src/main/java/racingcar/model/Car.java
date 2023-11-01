package racingcar.model;

import java.util.List;

public class Car {
    public static final int RANDOM_NUMBER_RANGE_START = 0;
    public static final int RANDOM_NUMBER_RANGE_END = 9;
    private static final int MIN_MOVEMENT_THRESHOLD = 4;

    private static final String CAR_MARK = "-";
    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrStop(int num) {
        position += Boolean.compare(num >= MIN_MOVEMENT_THRESHOLD, Boolean.TRUE) + 1;
    }

    public String getCarTrail() {
        return name + " : " + CAR_MARK.repeat(position);
    }
}
