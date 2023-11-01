package racingcar.service;

import static racingcar.util.Constants.*;
import static racingcar.util.Messages.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.dto.CarDTO;

public class RacingService {
    private final CarService carService;

    public RacingService() {
        carService = new CarService();
    }

    public void saveCars(List<Car> cars) {
        cars.forEach(carService::saveCar);
    }

    public static List<Car> convertToCarList(String cars) {
        return Arrays.stream(cars.split(COMMA))
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public void race() {
        List<Car> cars = carService.findCars();
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)));
    }

    public List<String> getWinner() {
        int maxMoveCount = carService.getMaxMoveCount();

        return carService.findCars()
                .stream()
                .filter(car -> car.isSameMoveCount(maxMoveCount))
                .map(Car::toDTO)
                .map(CarDTO::getName)
                .collect(Collectors.toList());
    }

    public String winnerToString() {
        List<String> winner = getWinner();
        return String.join(COMMA, winner);
    }
}
