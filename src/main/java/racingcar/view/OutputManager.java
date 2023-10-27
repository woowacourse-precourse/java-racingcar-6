package racingcar.view;

import java.util.List;

public class OutputManager {
    private static final String REQUEST_CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_GAME_COUNT_INPUT = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    private static final String GAME_OVER = "게임을 종료합니다...";

    public void printWithNewLine(String s) {
        System.out.println(s);
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void printRequestCarNameInputMessage() {
        printWithNewLine(REQUEST_CAR_NAME_INPUT);
    }

    public void printRequestGameCountInputMessage() {
        printWithNewLine(REQUEST_GAME_COUNT_INPUT);
    }

    public void printResultNoticeMessage() {
        printWithNewLine(RESULT);
    }

    public void printCarsPosition(List<String> carsTrail) {
        carsTrail.forEach(this::printWithNewLine);
        printWithNewLine("");
    }

    public void printWinners(List<String> winners) {
        printWithNewLine(WINNER + String.join(", ", winners));
    }

    public void printGameOver() {
        printWithNewLine(GAME_OVER);
    }
}
