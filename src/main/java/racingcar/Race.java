package racingcar;

import java.util.Collections;
import java.util.List;

public class Race {
    private final List<Car> carList;

    public Race(final List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    public List<Car> getFarthestCarList() {
        int maxPosition = 0;
        for (Car car : carList) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        final int finalMaxPosition = maxPosition;
        return carList.stream()
                .filter(car -> car.getPosition() == finalMaxPosition)
                .toList();
    }
}
