package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private String name;
    private int straightCount;

    private Car(String name, int straightCount) {
        this.name = name;
        this.straightCount = 0;
    }

    public static Car createForStart(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return new Car(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getStraightCount() {
        return straightCount;
    }

    public void moveStraight(int randomValue) {
        if (randomValue >= 4) {
            straightCount++;
        }
    }

    public static List<Car> create(String[] cars) {
        return Arrays.stream(cars).map(Car::createForStart).collect(Collectors.toList());
    }
}
