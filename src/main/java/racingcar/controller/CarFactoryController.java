package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.vo.CarName;

public class CarFactoryController {

    CarFactory carFactory;

    public Cars createRacingCars(String carNamesString) {

        List<CarName> carNames = Arrays.stream(carNamesString.split(","))
                .map(CarName::new)
                .toList();
        return carFactory.createCarsWithNames(carNames);
    }




}
