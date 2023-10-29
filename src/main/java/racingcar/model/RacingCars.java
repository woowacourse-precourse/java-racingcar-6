package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.InputValueValidator;
import racingcar.util.RandomNumberGenerator;

public class RacingCars {

    private final List<Car> carList;
    private final InputValueValidator inputValueValidator;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCars() {
        this.carList = new ArrayList<>();
        this.inputValueValidator = new InputValueValidator();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public List<Car> createRacingCars(String carName) {
        List<String> carNames = inputValueValidator.validateName(carName);

        for (String name : carNames) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

}
