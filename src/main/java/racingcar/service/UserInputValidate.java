package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.ExceptionMessage;
import racingcar.domain.Car;
import racingcar.domain.Standard;

public class UserInputValidate {
    public List<Car> validate(String[] names) {
        validationMethod(names == null, ExceptionMessage.NULL_INPUT_ERROR_MESSAGE);
        validationMethod(names.length == 0, ExceptionMessage.EMPTY_INPUT_ERROR_MESSAGE);

        return Arrays.stream(names)
                .peek(this::carNameValidate)
                .map(name -> Car.createCar(name))
                .collect(Collectors.toList());
    }

    private void carNameValidate(String name) {
        validationMethod(name.length() > Standard.Five.getValue(), ExceptionMessage.CAR_NAME_LENGTH_ERROR_MESSAGE);
    }

    public long tryCountValidate(String moveCount) {
        validationMethod(moveCount == null, ExceptionMessage.NULL_INPUT_ERROR_MESSAGE);

        long mvCount = 0;
        try {
            mvCount = Long.parseLong(moveCount);
        } catch (NumberFormatException e) {
            ExceptionMessage.NOT_INTEGER_VALUE_ERROR_MESSAGE.throwException();
        }
        validationMethod(mvCount < 1, ExceptionMessage.DISABLE_INPUT_ERROR_MESSAGE);
        return mvCount;
    }

    private void validationMethod(boolean moveCount, ExceptionMessage exceptionMessage) {
        if (moveCount) {
            exceptionMessage.throwException();
        }
    }
}
