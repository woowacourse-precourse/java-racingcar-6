package racingcar.printer;

import java.util.List;
import racingcar.domain.Car;
import racingcar.evaluator.WinnerEvaluator;
import racingcar.message.Console;

public class ResultPrinter {

    private static final int SINGLE_WINNER_SIZE = 1;
    private static final String SEPARATOR = ", ";

    private final WinnerEvaluator evaluator;

    public ResultPrinter(WinnerEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    public void print(List<Car> cars) {
        List<String> winners = evaluator.getWinners(cars);
        if (winners.size() == SINGLE_WINNER_SIZE) {
            printSingle(winners.get(0));
        } else {
            printMultiple(winners);
        }
    }

    public void printSingle(String winner) {
        Console.resultWinner(winner);
    }

    public void printMultiple(List<String> winners) {
        String result = buildWinner(winners);
        Console.resultWinner(result);
    }

    public String buildWinner(List<String> winners) {
        return String.join(SEPARATOR, winners);
    }
}
