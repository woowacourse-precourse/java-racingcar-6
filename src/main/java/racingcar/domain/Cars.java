package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.moveByRandomNumber();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinnersName() {
        int maxPosition = getMaxPosition();

        if (noMovementCheck(maxPosition)) {
            return Collections.emptyList();
        }

        return findWinners(maxPosition);
    }

    private boolean noMovementCheck(int maxPosition) {
        return maxPosition == 0;
    }

    private List<String> findWinners(int maxPosition) {
        return getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : getCars()) {
            if (car.getPosition() > maxPosition)
                maxPosition = car.getPosition();
        }
        return maxPosition;
    }


}