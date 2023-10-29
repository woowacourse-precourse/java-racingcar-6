package racingcar.domain.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        printStartMessage();
        String carNames = input();
        return carNames;
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
