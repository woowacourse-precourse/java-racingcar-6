package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String DISTANCE_UNIT = "-";
    private static final String MESSAGE_AND_RESULT_DELIMITER = " : ";
    private static final String NAME_DELIMITER = ",";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";

    public void printCarNameAndPosition(String carName, int position) {
        StringBuilder carNameAndPosition = new StringBuilder();
        carNameAndPosition.append(carName);
        carNameAndPosition.append(MESSAGE_AND_RESULT_DELIMITER);
        carNameAndPosition.append(DISTANCE_UNIT.repeat(position));

        System.out.println(carNameAndPosition);
    }

    public void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printWinners(List<String> winners) {
        StringBuilder winnersResult = new StringBuilder();
        winnersResult.append(WINNER_MESSAGE);
        winnersResult.append(MESSAGE_AND_RESULT_DELIMITER);

        winnersResult.append(String.join(NAME_DELIMITER, winners));

        System.out.println(winnersResult);
    }

    public void printNewLine() {
        System.out.println();
    }
}
