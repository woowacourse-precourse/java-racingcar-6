package service;

import domain.Car;
import exception.RacingCarException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    public static RacingCarException racingCarException = new RacingCarException();
    public List<String> stringToList(String carName) {
        List<String> carNames = Arrays.asList(carName.split(","));
        racingCarException.validateDuplicateName(carNames);
        for(String car : carNames) {
            racingCarException.validateCarNameLength(car);
            racingCarException.validateEmptyName(car);
        }
        return carNames;
    }

    public List<Car> initRacingCars(List<String>carNames) {
        List<Car> racingCars = new ArrayList<>();
        for(int i=0; i<carNames.size(); i++) {
            racingCars.add(new Car(carNames.get(i)));
        }
        return racingCars;
    }

}
