package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.dto.StatusResponse;

public class OutputView {

    private static final String PLAY_RESULT_MESSAGE = "실행 결과";
    private static final String HYPHEN = "-";

    public static void printPlayResultMessage() {
        print(PLAY_RESULT_MESSAGE);
    }

    public static void printStatus(StatusResponse response) {
        LinkedHashMap<String, Integer> status = response.getStatus();
        for (String name : status.keySet()) {
            print(String.format("%s : %s", name, HYPHEN.repeat(status.get(name))));
        }
        print("");
    }

    public static void printWinner(List<String> winner) {
        print(String.format("%s : %s", "최종 우승자", String.join(",", winner)));
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
