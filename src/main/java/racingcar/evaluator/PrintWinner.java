package racingcar.evaluator;

import java.util.List;
import racingcar.message.Console;

public class PrintWinner {

    void print(List<String> winners) {
        if (winners.size() == 1) {
            printSingleWinner(winners.get(0));
        } else {
            printMultipleWinners(winners);
        }
    }

    void printSingleWinner(String winner) {
        Console.resultWinner(winner);
    }

    void printMultipleWinners(List<String> winners) {
        String result = buildWinner(winners);
        Console.resultWinner(result);
    }

    String buildWinner(List<String> winners) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i));

            if (i < winners.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
