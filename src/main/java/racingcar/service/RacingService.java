package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingService {
    private final CarService carService;

    public RacingService() {
        carService = new CarService();
    }

    public void saveCars(List<Car> cars) {
        cars.forEach(carService::saveCar);
    }

    public static List<Car> convertToCarList(String cars) {
        return Arrays.stream(cars.split(","))
                .map(Car::of)
                .collect(Collectors.toList());
    }
}
