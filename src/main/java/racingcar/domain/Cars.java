package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        return new Cars(cars);
    }

    public void moveForward() {
        cars.forEach(car -> {
            car.attemptMovingForward();
            car.printCar();
        });
    }

    public List<Car> getWinnerCars() {
        int maxPosition = getMaxPosition();
        return getCarsAtMaxPosition(maxPosition);
    }

    private int getMaxPosition() {
        int max = -1;
        for (Car car : cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    private List<Car> getCarsAtMaxPosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
