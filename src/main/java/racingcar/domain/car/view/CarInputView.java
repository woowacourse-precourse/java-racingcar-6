package racingcar.domain.car.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;

import static racingcar.domain.util.ErrorMessage.*;
import static racingcar.domain.util.InputMessage.*;

public class CarInputView {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public List<String> getCarNames() {
        printGameStart();
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(",", -1))
                .filter(this::checkValidCarNameLength)
                .toList();
    }

    private void printGameStart() {
        System.out.println(RECEIVE_CAR_NAME.getMessage());
    }


    private boolean checkValidCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER.getErrorMessage());
        }

        if (carName.length() == 0) {
            throw new IllegalArgumentException(CAR_NAME_IS_EMPTY.getErrorMessage());
        }

        return true;
    }

    public int getTryCount() {
        printTryCount();
        String tryCount = Console.readLine();
        checkTryCountIsValid(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void checkTryCountIsValid(String tryCount) {
        checkIsDigit(tryCount);
        checkTryCountZero(tryCount);
    }

    private void checkTryCountZero(String tryCount) {
        if (isTryCountZero(tryCount)) {
            throw new IllegalArgumentException(TRY_COUNT_IS_ZERO.getErrorMessage());
        }
    }

    private boolean isTryCountZero(String tryCount) {
        return Integer.parseInt(tryCount) == 0;
    }

    private void checkIsDigit(String userInput) {
        if (isDigit(userInput)) {
            return;
        }

        throw new IllegalArgumentException(TRY_COUNT_IS_NOT_DIGIT.getErrorMessage());
    }

    private boolean isDigit(String userInput) {
        return userInput.chars()
                .allMatch(Character::isDigit);
    }

    private void printTryCount() {
        System.out.println(RECEIVE_TRY_COUNT.getMessage());
    }
}
