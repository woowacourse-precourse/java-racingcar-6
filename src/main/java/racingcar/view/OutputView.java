package racingcar.view;

import java.util.List;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.GameStatus;

public class OutputView {

    public static void printWinner(GameResult result) {
        List<String> winnersList = result.winners();
        String winners = String.join(", ", winnersList);

        Messages.WINNER.print();
        System.out.println(winners);
    }

    public static void printStatus(GameStatus status) {
        String name = status.name();
        Long position = status.position();

        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
