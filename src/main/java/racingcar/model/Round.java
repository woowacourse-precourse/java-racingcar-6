package racingcar.model;

import java.util.List;

public class Round {
    private static final int moveCondition = 4;

    public static String race(List<Car> cars) {
        for (Car car : cars) {
            if (car.generateMoveValue() >= moveCondition) {
                car.move();
            }
        }
        return CurrentResultMap.getCurrentResultMap(cars);
    }
}
