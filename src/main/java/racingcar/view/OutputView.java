package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printStartGame() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public void printAskAttemptsNumber() {
        System.out.println(INPUT_ATTEMPTS_NUMBER);
    }

    public void printRacingStatus() {
        System.out.println(GAME_RESULT);
        // TODO
    }

    public void printRacingResult(List<String> winners) {
        System.out.println(FINAL_WINNER + String.join(", ", winners));
    }
}
