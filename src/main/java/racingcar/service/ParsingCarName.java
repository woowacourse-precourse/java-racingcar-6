package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.repository.SaveCarList;
import racingcar.service.Exception;

import java.util.Arrays;
import java.util.List;

public class ParsingCarName {
    private SaveCarList saveCarList;
    private Exception exception = new Exception();

    public ParsingCarName(SaveCarList saveCarList, CarList carList) {
        this.saveCarList = new SaveCarList(carList);
    }

    public void parsingInput(String inputCars) {
        exception.duplicateCarNameException(inputCars);
        for (String carName : inputCars.split(",")) {
            exception.carNameLength(carName);
            exception.carNameIsDigit(carName);
            exception.noInputCarNameException(carName);
             Car car = new Car(carName);
            saveCarList.addCar(car);
        }
    }
}

//        new ArrayList<>(Arrays.asList(inputCars.split(",")));
