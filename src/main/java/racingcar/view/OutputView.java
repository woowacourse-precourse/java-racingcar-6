package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(Cars cars) {
        System.out.println(cars);
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(WINNER_MESSAGE_FORMAT.formatted(String.join(", ", winnerNames)));
    }
}
