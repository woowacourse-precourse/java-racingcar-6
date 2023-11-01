package racingcar;

import racingcar.Domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    public static List<Car> findMaxPosition(List<Car> cars) {
        List<Car> carsWithMaxPosition = new ArrayList<>();
        Long maxPosition = Long.MIN_VALUE;
        for(Car car : cars) {
            int compareResult = isMaxPosition(car, maxPosition);
            maxPosition = setCarsWithMaxPosition(carsWithMaxPosition, compareResult, car, maxPosition);
        }
        return carsWithMaxPosition;
    }

    private static int isMaxPosition(Car car, Long maxPosition) {
        if (car.getPosition() > maxPosition) {
            return 1;
        }
        if (car.getPosition() == maxPosition) {
            return 0;
        }
        return -1;
    }

    private static Long setCarsWithMaxPosition(List<Car> carsWithMaxPosition, int compareResult, Car car, Long maxPosition) {
        if (compareResult == 1) {
            carsWithMaxPosition.clear();
            carsWithMaxPosition.add(car);
            return car.getPosition();
        }
        if (compareResult == 0) {
            carsWithMaxPosition.add(car);
        }
        return maxPosition;
    }
}
