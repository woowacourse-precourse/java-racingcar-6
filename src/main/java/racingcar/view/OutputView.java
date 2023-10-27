package racingcar.view;

import static racingcar.view.Constants.NEXT_LINE;
import static racingcar.view.Constants.RESULT_MESSAGE_START;
import static racingcar.view.Constants.WINNER_IS;

import java.util.List;
import racingcar.model.Car;

public class OutputView implements View {
    private final StringBuilder result;

    OutputView() {
        result = new StringBuilder();
        result.append(RESULT_MESSAGE_START.getMessage());
    }

    public void recordStatus(final List<Car> cars) {
        cars.forEach(car -> result.append(car.toString()).append(NEXT_LINE.getMessage()));
        result.append(NEXT_LINE.getMessage());
    }

    public void recordWinner(final List<String> winners) {
        result.append(WINNER_IS.getMessage());
        result.append(winners.toString(), 1, winners.toString().length() - 1);
    }

    public void printResult() {
        System.out.println(result);
    }
}
