package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.CarDto;
import racingcar.model.ScoreBoard;

public class OutputView {
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String BEFORE_RACE_MESSAGE = "실행 결과";
    private static final String DISTANCE_DASH = "-";
    private static final String FIELD_SEPARATOR = " : ";
    private static final String NEW_LINE = "\n";
    private static final String COMMA = ", ";

    public static void beforeRaceMessage() {
        printEmptyLine();
        System.out.println(BEFORE_RACE_MESSAGE);
    }

    public static void showScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int round = 1; round <= scoreBoard.getSize(); round++) {
            List<CarDto> score = scoreBoard.getScoreForRound(round);
            for (CarDto carDto : score) {
                stringBuilder.append(carDto.getName())
                        .append(FIELD_SEPARATOR)
                        .append(DISTANCE_DASH.repeat(carDto.getDistance()))
                        .append(NEW_LINE);
            }
            stringBuilder.append(NEW_LINE);
        }
        System.out.print(stringBuilder);
    }

    public static void showWinners(List<CarDto> winners) {
        StringJoiner winnerNames = new StringJoiner(COMMA);
        winners.forEach(carDto -> winnerNames.add(carDto.getName()));
        System.out.println(FINAL_WINNER + FIELD_SEPARATOR + winnerNames);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

}
