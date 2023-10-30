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

}
