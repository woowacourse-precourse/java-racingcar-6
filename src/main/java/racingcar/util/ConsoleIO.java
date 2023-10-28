package racingcar.util;

import static racingcar.constant.GameMessage.PLAY_RESULT_MESSAGE;
import static racingcar.constant.GameMessage.REQUEST_INPUT_CAR_NAME_MESSAGE;
import static racingcar.constant.GameMessage.REQUEST_INPUT_GAME_SET_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleIO {
    public static String readCarName() {
        System.out.println(REQUEST_INPUT_CAR_NAME_MESSAGE);

        return Console.readLine();
    }

    public static String readGameSet() {
        System.out.println(REQUEST_INPUT_GAME_SET_MESSAGE);

        return Console.readLine();
    }

    public static void printPlayResultMessage() {
        printNewLine();
        System.out.println(PLAY_RESULT_MESSAGE);
    }

    public static void printSetResult(StringBuilder setResult) {
        System.out.println(setResult);
    }

    public static void printFinalResult(StringBuilder finalResult) {
        System.out.println(finalResult);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
