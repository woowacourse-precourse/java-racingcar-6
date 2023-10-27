package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static final int MOVE_CONDITION = 4;
    public static final int CAR_NAME_LIMIT_SIZE = 5;
    public static int carCondition;

    private static List<String> cars = new ArrayList<>();

    public Car(List<String> car) {
        this.cars = car;
    }

    public List<String> getInstance() {
        return this.cars;
    }
}
