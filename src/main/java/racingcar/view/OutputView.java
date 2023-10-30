package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public record OutputView() {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(Cars cars) {
        cars.getCars().forEach(System.out::println);
        System.out.println();
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(WINNER_MESSAGE_FORMAT.formatted(String.join(", ", winnerNames)));
    }
}
