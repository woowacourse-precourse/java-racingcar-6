package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.validator.GameValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public List<Car> inputCarNames() {

        String cars = getCars();

        return Arrays.stream(cars.split(DELIMITER))
                .map(String::trim)
                .map(Car::makeCar)
                .toList();
    }

    public int inputTryCount() {

        String tryCountString = Console.readLine();
        GameValidator.validateIsNumber(tryCountString);

        int tryCount = Integer.parseInt(tryCountString);
        GameValidator.validateTryCount(tryCount);

        return tryCount;
    }

    private String getCars() {

        String cars = Console.readLine();
        GameValidator.validateCarNumberIsOverTwo(cars);
        GameValidator.validateZeroCarName(cars);

        Arrays.stream(cars.split(DELIMITER))
                .forEach(GameValidator::validateCarNamesLength);

        return cars;
    }
}
