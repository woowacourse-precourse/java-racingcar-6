package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getMaxCars() {
        List<String> maxCars = new ArrayList<>();
        int max = getMaxForwardCounts();

        for (Car car : cars) {
            if (car.getForwardCount() == max) {
                maxCars.add(car.getName());
            }
        }

        return maxCars;
    }

    private int getMaxForwardCounts() {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }

    @Override
    public String toString() {
        return "CarRepository{" +
                "carRepository=" + cars +
                '}';
    }
}
