package racingcar;

import static racingcar.InputValidator.*;
import static racingcar.MessageManager.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getInputCarNameMessage();
        String inputCarName = InputProcessor.readLine();
        String[] carName = inputCarName.split(",");

        validateContainsCommaAndBlank(inputCarName);
        validateContainsCommaSeparator(inputCarName);
        validateStringLengthInArray(carName);

        getInputNumberOfAttemptsMessage();
        String countNumber = InputProcessor.readLine();
        System.out.println();

        validateNonPositiveOrNonInteger(countNumber);

        int inputCount = Integer.parseInt(countNumber);

        Race.startRace(carName, inputCount);
    }
}
