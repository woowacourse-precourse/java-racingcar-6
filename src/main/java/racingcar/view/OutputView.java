package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String PLAY_RESULT = "\n실행 결과";
    public static final String ERROR = "[ERROR] 잘못된 입력으로 프로그램을 종료합니다.";
    public static void showStatus() {
        System.out.println(PLAY_RESULT);
    }

    public static void showWinners(List<String> winners) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String winner : winners) {
            joiner.add(winner);
        }
        System.out.println("최종 우승자 : " + joiner.toString());
    }

    public static void showError(String message) {
        System.out.println(ERROR + message);
    }
}
