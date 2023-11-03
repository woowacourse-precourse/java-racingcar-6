package racingcar.view;

import java.util.List;
import racingcar.model.MoveResult;
import racingcar.model.RoundResult;
import racingcar.model.Winners;

public class OutputView {

    private static final String RACING_RESULT_TITLE = "실행 결과";
    private static final String RACING_RESULT_LINE_FORMAT = "%s : %s\n";
    private static final String RACING_SCORE_FORMAT = "-";
    private static final String RACING_WINNERS_FORMAT = "최종 우승자 : %s";
    private static final String RACING_WINNERS_NAME_DELIMITER = ", ";


    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private OutputView() {
        throw new AssertionError();
    }

    public static void printRoundResults(final List<RoundResult> roundResults) {
        printRacingResultTitle();
        for (final RoundResult roundResult : roundResults) {
            printRaceScores(roundResult.getResults());
        }
    }

    private static void printRacingResultTitle() {
        System.out.println();
        System.out.println(RACING_RESULT_TITLE);
    }

    private static void printRaceScores(final List<MoveResult> scores) {
        for (final MoveResult score : scores) {
            printRacingScore(score);
        }
        System.out.println();
    }

    private static void printRacingScore(final MoveResult score) {
        System.out.printf(RACING_RESULT_LINE_FORMAT,
                score.name(),
                formatRacingScore(score)
        );
    }

    private static String formatRacingScore(final MoveResult score) {
        return RACING_SCORE_FORMAT.repeat(score.position());
    }

    public static void printWinners(final Winners winners) {
        System.out.printf(RACING_WINNERS_FORMAT, formatWinners(winners));
    }

    private static String formatWinners(final Winners winners) {
        return String.join(RACING_WINNERS_NAME_DELIMITER, winners.getNames());
    }
}
