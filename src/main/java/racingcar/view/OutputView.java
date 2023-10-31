package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.dto.StatusResponse;

public class OutputView {

    public static final String FINAL_WINNER_MESSAGE = "최종 우승자";
    private static final String HYPHEN = "-";
    private static final String PLAY_RESULT_MESSAGE = "실행 결과";
    public static final String PATTERN = "%s : %s";

    public static void printPlayResultMessage() {
        print(PLAY_RESULT_MESSAGE);
    }

    public static void printStatus(StatusResponse response) {
        LinkedHashMap<String, Integer> status = response.getStatus();
        for (String name : status.keySet()) {
            print(String.format(PATTERN, name, HYPHEN.repeat(status.get(name))));
        }
        lineBreak();
    }

    public static void printWinner(List<String> winner) {
        print(String.format(PATTERN, FINAL_WINNER_MESSAGE, String.join(",", winner)));
    }

    private static void lineBreak() {
        print("");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
