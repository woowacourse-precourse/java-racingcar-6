package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.validator.GameValidator;

import java.util.Arrays;

public class InputView {

    private static final String DELIMITER = ",";

    public Cars inputCarNames() {

        String cars = getCars();

        return new Cars(Arrays.stream(cars.split(DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .toList());
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
