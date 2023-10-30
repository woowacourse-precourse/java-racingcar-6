package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

public class CarListCreator {

    private static final String NAME_DELIMITER = ",";
    public static List<Car> generateCarListFromInput() {
        String carNames = InputView.getCarNames();
        String[] splitCarNames = splitCarNames(carNames);
        CarNameValidator.validateCarNames(splitCarNames);
        return CarListCreator.createCars(splitCarNames, new RandomNumberGenerator());
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(NAME_DELIMITER);
    }

    private static List<Car> createCars(String[] carNames, NumberGenerator numberGenerator) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
        return cars;
    }
}
