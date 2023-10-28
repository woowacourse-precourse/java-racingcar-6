package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;

public class CarObject {
    public static final int MOVE_CONDITION = 4;
    public static final int CAR_NAME_LIMIT_SIZE = 5;
    private static ArrayList<CarComponent> cars;

    private CarObject(CarComponent component) {
        cars.add(component);
    }

    public static CarObject nameOf(String name, Integer distance) {
        return new CarObject(new CarComponent(name, distance));
    }
}
