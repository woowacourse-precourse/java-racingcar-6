package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.ScoreBoard;
import racingcar.model.ScoreDto;

public class OutputView {
    private static final String DISTANCE_DASH = "-";

    public static void displayRaceResultMessage() {
        printEmptyLine();
        System.out.println("실행 결과");
    }

    public static void displayScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder roundScoresStringBuilder = new StringBuilder();
        for (int round = 1; round <= scoreBoard.getSize(); round++) {
            List<ScoreDto> score = scoreBoard.getScoreForRound(round);
            score.forEach(scoreDto -> roundScoresStringBuilder.append(scoreDto.getName())
                    .append(" : ")
                    .append(DISTANCE_DASH.repeat(scoreDto.getDistance()))
                    .append("\n"));
            roundScoresStringBuilder.append("\n");
        }
        System.out.print(roundScoresStringBuilder);
    }

    public static void displayWinners(List<ScoreDto> winners) {
        StringJoiner winnerNamesJoiner = new StringJoiner(", ");
        winners.forEach(scoreDto -> winnerNamesJoiner.add(scoreDto.getName()));
        System.out.println(
                "최종 우승자 : " + winnerNamesJoiner);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

}
