package racingcar;

import java.util.List;

public class Calculator {
    private static final int THERE_IS_NO_MAX = -1;

    public static int MaxMove(List<Car> cars) {
        int max = cars.stream()
                .map(Car::getTotalMoveLen)
                .max(Integer::compareTo)
                .orElse(THERE_IS_NO_MAX);
    }
}
