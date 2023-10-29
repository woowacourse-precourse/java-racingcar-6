package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.validator.GameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<Car> inputCarNames() {

        String cars = getCars();

        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
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

        Arrays.stream(cars.split(","))
                .forEach(GameValidator::validateCarNamesLength);

        return cars;
    }
}
