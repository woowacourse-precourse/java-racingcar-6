package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String PROMPT_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_FOR_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자";

    public static void displayCarNamePrompt() {
        System.out.println(PROMPT_FOR_CAR_NAMES);
    }

    public static void displayAttemptPrompt() {
        System.out.println(PROMPT_FOR_ATTEMPTS);
    }
    public static void displayCurrentGameResult(List<String> carNames, List<String> gameResults) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(String.format("%s : %s", carNames.get(i), gameResults.get(i)));
        }
    }
    public static void displayResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public static void displayWinner(String name) {
        System.out.println(String.format("%s : %s", WINNER_ANNOUNCEMENT, name));
    }

}
