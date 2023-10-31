package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.SaveCarList;

import java.util.List;

public class ParsingCarName {
    SaveCarList saveCarList = new SaveCarList();
    Car car = new Car();

    public void parsingInput(String inputCars) {
        for (String carName : inputCars.split(",")) {
            car.setName(carName);
            saveCarList.addCar(car);
        }

    }
}

