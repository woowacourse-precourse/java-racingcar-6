package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.Validation;

public final class Input {

    public static String getCarNames() {
        String carNames = Console.readLine();
        Validation.validateIsNotNull(carNames);
        Validation.validateSeparator(carNames);
        return carNames;
    }

    public static String getTryNumber() {
        String tryNumber = Console.readLine();
        Validation.validateIsDigit(tryNumber);
        Validation.validateTryNumber(tryNumber);
        return tryNumber;
    }
}
