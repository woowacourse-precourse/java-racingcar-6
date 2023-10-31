package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public Cars registerCar(String carNames) {
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }

        return this;
    }

    public List<Car> getMaxMoveCars() {
        List<Car> maxMoveCars = new ArrayList<>();
        Integer maxValue = 0;

        for (Car car : cars) {
            Integer moveCount = car.getMoveCount();

            if (maxValue < moveCount) {
                maxValue = moveCount;
                maxMoveCars.clear();
                maxMoveCars.add(car);
                continue;
            }

            if (maxValue.equals(moveCount)) {
                maxMoveCars.add(car);
            }
        }

        return maxMoveCars;
    }
}
