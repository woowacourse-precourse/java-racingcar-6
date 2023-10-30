package racingcar.utill;

import static racingcar.utill.Validator.attemptNumberValidation;
import static racingcar.utill.Validator.nullInputValidation;

import camp.nextstep.edu.missionutils.Console;

public class CustomReadLine {

    public String carsNameInput() {
        String carsName = Console.readLine();
        nullInputValidation(carsName);
        return carsName;
    }

    public int attemptNumberInput() {
        String attemptNumber = Console.readLine();
        nullInputValidation(attemptNumber);
        attemptNumberValidation(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }
}
