package racingcar.model;

import java.util.HashMap;

public class CarObject {
    public static final int MOVE_CONDITION = 4;
    public static final int CAR_NAME_LIMIT_SIZE = 5;
    private static HashMap<String, Integer> cars;

    private CarObject(HashMap<String, Integer> cars) {
        this.cars = cars;
    }

    public static CarObject nameOf(HashMap<String, Integer> cars) {
        return new CarObject(cars);
    }
}
