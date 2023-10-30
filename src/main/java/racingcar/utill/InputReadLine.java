package racingcar.utill;

import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.nullInputValidation;

import camp.nextstep.edu.missionutils.Console;

public class InputReadLine {

    public static String carsNameInput() {
        String carsName = Console.readLine();
        nullInputValidation(carsName);
        return carsName;
    }

    public static String attemptNumberInput() {
        String attemptNumber = Console.readLine();
        nullInputValidation(attemptNumber);
        attemptNumberValidation(attemptNumber);
        return attemptNumber;
    }
}
