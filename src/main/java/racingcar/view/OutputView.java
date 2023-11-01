package racingcar.view;

import static racingcar.constant.PrintMessage.PRINT_GAME_RESULT;
import static racingcar.constant.PrintMessage.WINNER_NAME_FORMAT;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String WINNER_RACING_CAR_NAME_DELIMITER= ", ";

    public void printResult(StringBuilder resultBuilder) {
        System.out.println(PRINT_GAME_RESULT);
        System.out.println(resultBuilder);
    }

    public void printWinners(List<String> winnerNames) {
        StringJoiner winnerNamesJoiner = new StringJoiner(WINNER_RACING_CAR_NAME_DELIMITER);
        winnerNames.stream().forEach(name -> winnerNamesJoiner.add(name));
        System.out.println(String.format(WINNER_NAME_FORMAT, winnerNamesJoiner));
    }
}
