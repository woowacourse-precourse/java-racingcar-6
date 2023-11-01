package racingcar.view;

import racingcar.constant.Constant;

import java.util.ArrayList;

import static racingcar.constant.Message.WINNERS_INFO_MESSAGE;

public class OutputView {
    public void println(String text){
        System.out.println(text);
    }

    public static void printPlayMessage() {
        System.out.println(Constant.ROUND_RESULT);
    }

    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(ArrayList<String> winners){
        System.out.printf(WINNERS_INFO_MESSAGE, String.join(",",winners));
    }
}
