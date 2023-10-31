package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.dto.CarDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static racingcar.util.constant.NumberConstant.*;

public class GameManageService {
    private final CarService carService;
    private static final String COMMAS = ",";

    public GameManageService() {
        carService = new CarService();
    }

    public void saveCars(List<Car> cars) {
        cars.forEach(carService::saveCar);
    }


    public void race() {
        List<Car> cars = carService.findCars();
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)));
    }

    public List<String> getWinner() {
        int maxPosition = carService.getMaxPosition();

        return carService.findCars().stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::toDTO)
                .map(CarDTO::getCarName)
                .collect(Collectors.toList());
    }

    public String winnerToString() {
        List<String> winner = getWinner();
        return String.join(COMMAS, winner);
    }

    public static List<Car> convertToCarList(String cars) {
        return Arrays.stream(cars.split(COMMAS))
                .map(Car::of)
                .collect(Collectors.toList());
    }
}
