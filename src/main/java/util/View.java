package util;

import static constant.Message.CYCLE_INPUT_MESSAGE;
import static constant.Message.RACING_RESULT;
import static constant.Message.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static void printStartMessage() {
        System.out.println(START_MESSAGE.getMessage());
    }

    public static void printCycleInputMessage() {
        System.out.println(CYCLE_INPUT_MESSAGE.getMessage());
    }

    public static void printRacingResultMessage() { System.out.println("\n" + RACING_RESULT.getMessage()); }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static String input() {
        return Console.readLine();
    }

}
