package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    private static final String PRINT_GAME_RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_GAME_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String GAME_WINNER_DELIMITER = ", ";

    private OutputView() {
    }

    public static void printGameResultMessage() {
        System.out.println(PRINT_GAME_RESULT_MESSAGE);
    }

    public static void printCarStatuses(final List<CarDto> carStatus) {
        carStatus.stream()
                .map(CarDto::toString)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printGameWinnerMessage(final List<String> gameWinner) {
        System.out.println(PRINT_GAME_WINNER_MESSAGE + String.join(GAME_WINNER_DELIMITER, gameWinner));
    }
}
