package racingcar;

import java.util.List;

public class OutputView {
    private static final String REQUEST_INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String SPLIT_COMMA = ",";

    public void printRequestInputCarName() {
        System.out.println(REQUEST_INPUT_CAR_NAME_MESSAGE);
    }

    public void printRequestInputTryNumber() {
        System.out.println(REQUEST_INPUT_TRY_NUMBER_MESSAGE);
    }

    public void printPlayResult() {
        space();
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarGameWinnerName(List<String> winnerCarNames) {
        System.out.print(FINAL_WINNER_MESSAGE + gameWinnerJoin(winnerCarNames));
    }

    private String gameWinnerJoin(List<String> winnerCarNames) {
        return String.join(SPLIT_COMMA, winnerCarNames);
    }

    public void space() {
        System.out.println();
    }
}
