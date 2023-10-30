package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.TryCount;
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

    public TryCount inputTryCount() {

        String tryCountString = Console.readLine();
        GameValidator.validateIsNumber(tryCountString);

        int tryCount = Integer.parseInt(tryCountString);

        return new TryCount(tryCount);
    }

    private String getCars() {

        String cars = Console.readLine();
        GameValidator.validateCarNumberIsOverTwo(cars);
        GameValidator.validateZeroCarName(cars);

        return cars;
    }
}
