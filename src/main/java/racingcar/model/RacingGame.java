package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.NumberGenerator;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingGame(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void addCar(final Car car) {
        carList.add(car);
    }

    public void moveCar(final int carIndex) {
        final Car car = carList.get(carIndex);
        final int randomNumber = numberGenerator.createRandomNumber();
        car.moveForward(randomNumber);
    }
}
