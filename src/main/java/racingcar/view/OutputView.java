package racingcar.view;

import static racingcar.view.ConstantMessage.NEXT_LINE;
import static racingcar.view.ConstantMessage.RESULT_MESSAGE_START;
import static racingcar.view.ConstantMessage.WINNER_IS;

import java.util.List;
import racingcar.model.Car;

public class OutputView implements View {
    private final StringBuilder result;

    OutputView() {
        result = new StringBuilder();
        result.append(RESULT_MESSAGE_START.message());
    }

    public void recordStatus(final List<Car> cars) {
        cars.forEach(car -> result.append(car.toString()).append(NEXT_LINE.message()));
        result.append(NEXT_LINE.message());
    }

    public void recordWinner(final List<String> winners) {
        result.append(WINNER_IS.message());
        String stringWithBracket = winners.toString();
        int rightOfLeftBracket = 1, leftOfRightBracket = stringWithBracket.length() - 1;
        result.append(winners.toString(), rightOfLeftBracket, leftOfRightBracket);
    }

    public void printResult() {
        System.out.println(result);
    }
}