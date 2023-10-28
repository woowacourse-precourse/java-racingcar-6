package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarObject {
    public static final int MOVE_CONDITION = 4;
    public static final int CAR_NAME_LIMIT_SIZE = 5;
    public static int carCondition;
    private static List<String> cars;

    private CarObject(List<String> car) {
        this.cars = car;
    }

    public static CarObject nameOf(List<String> cars) {
        return new CarObject(cars);
    }
}
