package racingcar.view;

import racingcar.Constants;

import java.util.ArrayList;

public class OutputView {

    public static void printResultMessage() {
        System.out.println(Constants.ROUND_RESULT);
    }
    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }
    public static void printWinner(ArrayList<String> winners) {
        System.out.println(Constants.FINAL_WINNER + String.join(Constants.DELIMITER_WINNER, winners));
        // String.join() : 리스트 or 배열의 모든 요소를 하나의 문자열로 결합하고, 각 요소 사이에 구분자 삽입
    }
}
