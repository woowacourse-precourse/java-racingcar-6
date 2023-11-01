package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static racingcar.constant.Constant.CAR_NAME_SEPARATOR;
import static racingcar.constant.ErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE;

public class cars {
    private final List<car> carList;

    private cars(List<car> carList) {
        this.carList = carList;
    }

    public static cars fromCarNames(String carNames) {
        validate(carNames);
        List<car> cars = Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .map(car::fromName)
                .toList();

        return new cars(cars);
    }
    private static void validate(String carNames) {
        validateIsEndWithSeparator(carNames);
    }

    private static void validateIsEndWithSeparator(String carNames) {
        if (carNames.endsWith(CAR_NAME_SEPARATOR)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }

    public List<car> tryToMove() {
        for (car car : carList) {
            car.triesToMove();
        }
        return getCurrentStatus();
    }

    public List<car> getCurrentStatus() {
        return Collections.unmodifiableList(carList);
    }
}
