package service;

import domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarService {

    public List<String> stringToList(String carName) {
        List<String> carNames = Arrays.asList(carName.split(","));
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
