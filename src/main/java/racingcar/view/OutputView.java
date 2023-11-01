package racingcar.view;

import java.util.List;
import racingcar.dto.CarPositionResponse;
import racingcar.dto.WinnersNameResponse;

public class OutputView {

    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String DELIMITER = ", ";
    private static final String INPUT_CAR_NAMES_MESSAGE ="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_TRY_COUNTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    static void printInputTryCountMessage() {
        System.out.println(INPUT_GAME_TRY_COUNTS_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printExecutionResults(List<List<CarPositionResponse>> executionResults) {
        executionResults.forEach(this::printExecutionResult);
    }

    private void printExecutionResult(List<CarPositionResponse> executionResult) {
        executionResult.forEach(this::printCarPosition);
    }

    private void printCarPosition(CarPositionResponse carPositionResponse) {
        System.out.println(carPositionResponse.getName() + COLON + DASH.repeat(carPositionResponse.getPosition()));
    }

    public void printFinalResult(WinnersNameResponse winnersNameResponse) {
        System.out.println(FINAL_WINNER_MESSAGE + joinCarNames(winnersNameResponse.getWinnersName()));
    }

    private static String joinCarNames(List<String> carNames) {
        return String.join(DELIMITER, carNames);
    }
}
