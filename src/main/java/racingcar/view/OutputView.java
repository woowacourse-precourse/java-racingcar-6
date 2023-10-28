package racingcar.view;

import java.util.List;
import racingcar.controller.dto.RacingResultResponse;

public class OutputView {

    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String HYPHEN = "-";
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";

    public void printCarNamesInputMessage() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
    }

    public void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(final RacingResultResponse result) {
        System.out.print(result.getCarName() + COLON);
        printPositionResult(result.getCarPosition());
    }

    private void printPositionResult(final int count) {
        System.out.println(HYPHEN.repeat(count));
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printWinners(final List<String> winnerNames) {
        System.out.print(WINNER_MESSAGE + COLON);
        printWinnerNames(winnerNames);
    }

    private void printWinnerNames(final List<String> winnerNames) {
        System.out.println(String.join(COMMA, winnerNames));
    }
}
