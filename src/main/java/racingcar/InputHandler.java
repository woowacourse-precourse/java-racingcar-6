package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String[] inputCarNames() {
        String rawCarNames = Console.readLine();
        String[] carNamesArray = changeStringToArray(rawCarNames);
        return carNamesArray;
    }

    private static String[] changeStringToArray(String rawCarNames) {
        String[] carNames = rawCarNames.split(",");
        return carNames;
    }

    public static int inputNumberOfAttempts() {
        String rawNumberOfAttempts = Console.readLine();
        int numberOfAttempts = Integer.parseInt(rawNumberOfAttempts);
        return numberOfAttempts;
    }

    public static String[] makeCarNamesArray() {
        String[] carNamesArray = InputHandler.inputCarNames();
        Validator.checkValidCarNames(carNamesArray);
        return carNamesArray;
    }

    public static int makeNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = InputHandler.inputNumberOfAttempts();
        Validator.isValidNumberOfAttempts(numberOfAttempts);
        return numberOfAttempts;
    }

}
