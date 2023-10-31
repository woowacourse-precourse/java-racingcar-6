package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.constant.Messages;
import racingcar.constant.Symbols;
import racingcar.model.ScoreBoard;
import racingcar.model.ScoreDto;

public class OutputView {
    public static void beforeRaceMessage() {
        printEmptyLine();
        System.out.println(Messages.BEFORE_RACE_MESSAGE);
    }

    public static void showScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder roundScoresStringBuilder = new StringBuilder();
        for (int round = 1; round <= scoreBoard.getSize(); round++) {
            List<ScoreDto> score = scoreBoard.getScoreForRound(round);
            score.forEach(scoreDto -> roundScoresStringBuilder.append(scoreDto.getName())
                    .append(Symbols.SPACE + Symbols.FIELD_SEPARATOR + Symbols.SPACE)
                    .append(Symbols.DISTANCE_DASH.repeat(scoreDto.getDistance()))
                    .append(Symbols.NEW_LINE));
            roundScoresStringBuilder.append(Symbols.NEW_LINE);
        }
        System.out.print(roundScoresStringBuilder);
    }

    public static void showWinners(List<ScoreDto> winners) {
        StringJoiner winnerNamesJoiner = new StringJoiner(Symbols.COMMA + Symbols.SPACE);
        winners.forEach(carDto -> winnerNamesJoiner.add(carDto.getName()));
        System.out.println(
                Messages.FINAL_WINNER + Symbols.SPACE + Symbols.FIELD_SEPARATOR + Symbols.SPACE + winnerNamesJoiner);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

}
