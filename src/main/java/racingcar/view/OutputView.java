package racingcar.view;

import racingcar.domain.RoundHistory;
import racingcar.domain.GameResult;

import java.util.List;

public class OutputView {

    private static final String ROUTE = "-";
    private static final String SEPARATOR = " : ";

    public static void printGameResult(GameResult gameResult) {
        System.out.println(MessageConstraints.GAME_RESULT_MESSAGE.getValue());
        printGameHistories(gameResult.roundHistory());
    }

    private static void printGameHistories(final List<RoundHistory> gameHistories) {
        gameHistories
                .forEach(OutputView::printRouteByCars);

        System.out.println('\n');
    }

    private static void printRouteByCars(RoundHistory roundHistory) {
        roundHistory.roundResult()
                .forEach((name, distance) ->
                        System.out.print(name.value() + SEPARATOR + ROUTE.repeat(distance.value()) + '\n'));
        System.out.print("\n");
    }
}
