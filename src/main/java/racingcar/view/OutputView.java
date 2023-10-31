package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.ScoreBoard;
import racingcar.model.ScoreDto;

public class OutputView {
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String BEFORE_RACE_MESSAGE = "실행 결과";
    private static final String DISTANCE_DASH = "-";
    private static final String FIELD_SEPARATOR = ":";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String COMMA = ",";

    public static void beforeRaceMessage() {
        printEmptyLine();
        System.out.println(BEFORE_RACE_MESSAGE);
    }

    public static void showScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder roundScoresStringBuilder = new StringBuilder();
        for (int round = 1; round <= scoreBoard.getSize(); round++) {
            List<ScoreDto> score = scoreBoard.getScoreForRound(round);
            score.forEach(scoreDto -> roundScoresStringBuilder.append(scoreDto.getName())
                    .append(SPACE + FIELD_SEPARATOR + SPACE)
                    .append(DISTANCE_DASH.repeat(scoreDto.getDistance()))
                    .append(NEW_LINE));
            roundScoresStringBuilder.append(NEW_LINE);
        }
        System.out.print(roundScoresStringBuilder);
    }

    public static void showWinners(List<ScoreDto> winners) {
        StringJoiner winnerNamesJoiner = new StringJoiner(COMMA + SPACE);
        winners.forEach(carDto -> winnerNamesJoiner.add(carDto.getName()));
        System.out.println(FINAL_WINNER + SPACE + FIELD_SEPARATOR + SPACE + winnerNamesJoiner);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

}
