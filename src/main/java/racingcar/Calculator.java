package racingcar;

import java.util.List;

public class Calculator {
    private static final int THERE_IS_NO_MAX = -1;

    public static int maxMove(List<Car> cars) {
        return cars.stream()
                .map(Car::getTotalMoveLen)
                .max(Integer::compareTo)
                .orElse(THERE_IS_NO_MAX);
    }
}
