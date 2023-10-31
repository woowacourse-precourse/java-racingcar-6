package racingcar.domain;

import racingcar.resource.CarGameValue;
import racingcar.util.RandomUtil;
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

    public void carsMove() {
        this.cars.forEach(car -> {
            int randomNumber = RandomUtil.getRandomNumberRange(
                    CarGameValue.CAR_MOVE_MIN_NUMBER.getValue(),
                    CarGameValue.CAR_MOVE_MAX_NUMBER.getValue()
            );
            car.move(randomNumber);
        });
    }

    public List<String> carsResult() {
        return new ArrayList<>(cars.stream()
                .map(Car::result)
                .toList()
        );
    }

    public List<String> getWinner() {
        return this.cars.stream()
                .filter(car -> car.isSamePosition(getMaxPosition()))
                .map(Car::getName)
                .toList();
    }

    public int getMaxPosition() {
        return Collections.max(getPositions());
    }

    public List<Integer> getPositions() {
        return this.cars.stream().map(Car::getPosition).toList();
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
