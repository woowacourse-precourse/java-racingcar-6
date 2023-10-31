package racingcar.view;

import racingcar.domain.GameResult;
import racingcar.domain.Name;
import racingcar.domain.RoundHistory;

import java.util.List;

public class OutputView {

    private static final String ROUTE = "-";
    private static final String SEPARATOR = " : ";

    public static void printGameResult(GameResult gameResult) {
        System.out.println(MessageConstraints.GAME_RESULT_MESSAGE.getValue());
        printGameHistories(gameResult.roundHistory());
        printWinners(gameResult.winners());
    }

    private static void printWinners(final List<Name> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners.stream()
                .map(Name::value)
                .toList()));
    }

    private static void printGameHistories(final List<RoundHistory> gameHistories) {
        gameHistories
                .forEach(OutputView::printRouteByCars);

        System.out.println('\n');
    }

    private static void printRouteByCars(RoundHistory roundHistory) {
        roundHistory.roundResult().results()
                .forEach((name, distance) ->
                        System.out.print(name.value() + SEPARATOR + ROUTE.repeat(distance.value()) + '\n'));
        System.out.print("\n");
    }
}
