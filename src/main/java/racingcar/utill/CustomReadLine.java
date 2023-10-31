package racingcar.utill;

import static racingcar.utill.Validator.validateAttemptNumber;
import static racingcar.utill.Validator.validateNullInput;

import camp.nextstep.edu.missionutils.Console;

public class CustomReadLine {

    public String inputCarsName() {
        String carsName = Console.readLine();
        validateNullInput(carsName);
        return carsName;
    }

    public int inputAttemptNumber() {
        String attemptNumber = Console.readLine();
        validateNullInput(attemptNumber);
        validateAttemptNumber(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }
}
