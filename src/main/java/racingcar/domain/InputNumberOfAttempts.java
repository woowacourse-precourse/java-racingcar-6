package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputNumberOfAttempts {
    public int getNumberOfAttempts() {
        InputNumberOfAttemptsValidator inputValidator = new InputNumberOfAttemptsValidator();

        String inputNumber = Console.readLine();
        if (!inputValidator.isNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(inputNumber);
    }
}
