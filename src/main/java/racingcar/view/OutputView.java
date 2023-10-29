package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.GameStatus;
import racingcar.model.dto.GameResult;

public class OutputView {

    public static void printStatus(GameStatus status) {
        OutputView.printPosition(status.name(), status.position());
    }

    public static void printWinner(GameResult result) {
        List<String> winnersList = result.winners();
        String winners = winnersList.stream().map(String::valueOf).collect(Collectors.joining(", "));

        Messages.WINNER_ANNOUNCEMENT.print();
        System.out.println(winners);
    }

    private static void printPosition(String name, Long position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
