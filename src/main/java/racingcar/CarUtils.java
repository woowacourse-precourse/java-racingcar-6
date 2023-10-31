package racingcar;

import static racingcar.RacingConst.CAR_MOVABLE_NUMBER;

import java.util.HashMap;

public class CarUtils {

    public static Boolean isMovable(Integer number) {
        return number >= CAR_MOVABLE_NUMBER;
    }

    public static void move(HashMap<String, Integer> cars, String name) {
        Integer position = cars.get(name);
        cars.put(name, position + 1);
    }
}
