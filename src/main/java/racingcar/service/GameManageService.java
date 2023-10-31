package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManageService {
    private final CarService carService;

    public GameManageService() {
        carService = new CarService();
    }

    public void saveCars(List<Car> cars) {
        cars.forEach(carService::saveCar);
    }

    public void race() {
        List<Car> cars = carService.findCars();
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    public static List<Car> convertToCarList(String cars) {
        return Arrays.stream(cars.split(","))
                .map(Car::of)
                .collect(Collectors.toList());
    }
}
