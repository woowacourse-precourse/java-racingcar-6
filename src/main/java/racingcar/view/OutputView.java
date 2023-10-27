package racingcar.view;

import java.util.stream.IntStream;
import racingcar.controller.dto.RacingResultResponse;

public class OutputView {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

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
        System.out.print(result.getCarName() + " : ");
        printPositionResult(result.getCarPosition());
    }

    private void printPositionResult(final int count) {
        IntStream.range(0, count)
                .forEach(i -> System.out.print("-"));
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }
}
