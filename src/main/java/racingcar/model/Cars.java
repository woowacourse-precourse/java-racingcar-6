package racingcar.model;

import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        CarNameValidator validator = new CarNameValidator(carNames);
        validator.carNameList.stream().forEach(name -> cars.add(new Car(name)));
    }

    public void raceOneRound(List<Car> cars) {
        cars.stream().forEach(car -> car.printRoundResult());
    }
}
