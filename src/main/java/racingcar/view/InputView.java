package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.ValidationName;
import racingcar.util.ValidationNumber;

public class InputView {

    public static String inputCarNames() {
        printStartMessage();
        String carNames = input();
        ValidationName.validateCarNames(carNames);
        return carNames;
    }

    public static String inputAttemptNumber() {
        printAttemptMessage();
        String attemptNumber = input();
        ValidationNumber.validateAttemptNumber(attemptNumber);
        return attemptNumber;
    }

    public static void printStartMessage() {
        System.out.println(InputMessages.START.getMessage());
    }

    public static void printAttemptMessage() {
        System.out.println(InputMessages.ATTEMPT.getMessage());
    }

    public static String input() {
        String inputString = Console.readLine();
        return inputString;
    }
}
