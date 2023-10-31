package racingcar.model;

import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> cars = new ArrayList<>();

    public CarList(String carNames) {
        CarNameValidator validator = new CarNameValidator(carNames);
        validator.carNameList.stream().forEach(name -> cars.add(new Car(name)));
    }

    public void raceOneRound(CarList carList) {
        race(carList);
        printResult(carList);
    }

    public void race(CarList carList) {
        carList.cars.stream().forEach(car -> car.getResult());
    }

    public void printResult(CarList carList) {
        carList.cars.stream().forEach(car -> car.printRoundResult());
    }


}
