package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(String carNames) {
        this.carList = new ArrayList<>();
        makeCars(carNames);
    }

    private void makeCars(String carNames) {
        for (String carName : carNames.split(Constant.CAR_NAMES_DELIMITER)) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> toList() {
        return carList;
    }

    private int findMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}