package racingcar.service;

import static racingcar.constant.constantMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.constant.constantMessage.NEGATIVE_VALUE_ERROR_MESSAGE;
import static racingcar.constant.constantMessage.Not_Integer_VALUE_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Standard;

public class UserInputValidate {
    public List<Car> validate(String[] names) {
        return Arrays.stream(names)
                .peek(this::carNameValidate)
                .map(name -> Car.createCar(name))
                .collect(Collectors.toList());
    }

    private void carNameValidate(String name) {
        if (name.length() > Standard.Five.getValue()) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public long tryCountValidate(String moveCount) {
        long mvCount;
        try {
            mvCount = Long.parseLong(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Not_Integer_VALUE_ERROR_MESSAGE);
        }

        if (mvCount < 0) {
            throw new IllegalArgumentException(NEGATIVE_VALUE_ERROR_MESSAGE);
        }
        return mvCount;
    }
}
