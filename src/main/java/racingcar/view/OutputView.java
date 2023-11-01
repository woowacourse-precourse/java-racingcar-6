package racingcar.view;

import static racingcar.messages.ViewMessage.MOVEMENT;
import static racingcar.messages.ViewMessage.OUTPUT_CAR_RESULT;
import static racingcar.messages.ViewMessage.OUTPUT_RESULT;
import static racingcar.messages.ViewMessage.OUTPUT_WINNERS;
import static racingcar.messages.ViewMessage.SEPARATOR;

import java.util.List;
import racingcar.dto.Car;

public class OutputView {
    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printExecutionResult() {
        System.out.print(OUTPUT_RESULT);
    }

    public void printAllCarResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(OUTPUT_CAR_RESULT, car.getName(), MOVEMENT.repeat(car.getMoveCount()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        System.out.printf(OUTPUT_WINNERS, String.join(SEPARATOR, winnerNames));
    }
}
