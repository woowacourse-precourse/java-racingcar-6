package racingcar;

import java.util.Map;

import static racingcar.MessageConst.*;

public class PrintUtil {

    public static void printNumberOfCarsInputMsg() {
        System.out.println(NUMBER_OF_CARS_INPUT_MESSAGE);
    }

    public static void printNameOfCarInputMsg() {
        System.out.println(NAMES_OF_CARS_INPUT_MESSAGE);
    }

    public static void printMoveCountInputMsg() {
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
    }

    public static void printResultMsg() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printGameResultMsg(Map<String, String> raceScore) {
        raceScore.forEach((Key, Value) -> System.out.println(Key + " : " + Value));
        System.out.println();
    }

    public static void printWinnerMsg() {
        System.out.println(WINNER_MESSAGE);
    }

}
