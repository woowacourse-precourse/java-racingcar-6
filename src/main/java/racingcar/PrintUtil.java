package racingcar;

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

    public void printResultMsg() {
        System.out.println(RESULT_MESSAGE);

        StringBuilder sb = new StringBuilder();
        //결과값 구하는 로직 추가
    }

    public static void printWinnerMsg() {
        System.out.println(WINNER_MESSAGE);

        StringBuilder sb = new StringBuilder();
    }

}
