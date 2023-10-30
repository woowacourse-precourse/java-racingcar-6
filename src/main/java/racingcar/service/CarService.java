package racingcar.service;

import racingcar.domain.Car;
import racingcar.exception.RacingCarException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    public static RacingCarException racingCarException = new RacingCarException();
    public List<String> stringToList(String carName) {
        racingCarException.validateNull(carName);
        List<String> carNames = Arrays.stream(carName.split(","))
                        .map(String::trim)
                        .toList();
        racingCarException.validateDuplicateName(carNames);
        for(String car : carNames) {
            racingCarException.validateCarNameLength(car);
            racingCarException.validateEmptyName(car);
        }
        return carNames;
    }
    public List<Car> initRacingCars(List<String>carNames) {
        List<Car> racingCars = new ArrayList<>();
        for(String car: carNames) {
            racingCars.add(new Car(car));
        }
        return racingCars;
    }

}
