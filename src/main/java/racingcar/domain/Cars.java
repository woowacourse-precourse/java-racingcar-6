package racingcar.domain;

import racingcar.validation.CarNameValidator;
import racingcar.validation.StringValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    private Cars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public static Cars createCars(String carNameStrings) {
        StringValidator.stringIsNull(carNameStrings);
        StringValidator.stringIsBlank(carNameStrings);
        CarNameValidator carNameValidator = new CarNameValidator(carNameStrings);
        return new Cars(carNameValidator.validate());
    }

    public List<String> getWinner() {
        return this.cars.stream()
                .filter(car -> car.isWinner(getMaxPosition()))
                .map(Car::getName)
                .toList();
    }

    public int getMaxPosition() {
        return Collections.max(getPositions());
    }

    public List<Integer> getPositions() {
        return this.cars.stream().map(Car::getPosition).toList();
    }
}
