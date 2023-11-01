package racingcar;

import static racingcar.InputValidator.*;
import static racingcar.MessageManager.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getInputCarNameMessage();
        String inputCarName = InputProcessor.readLine();
        String[] carName = inputCarName.split(",");

        validateInputCarName(inputCarName);

        getInputNumberOfAttemptsMessage();
        String countNumber = InputProcessor.readLine();
        System.out.println();

        try {
            validateInput(countNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return;
        }

        int inputCount = Integer.parseInt(countNumber);

        Race.startRace(carName, inputCount);
    }
}
