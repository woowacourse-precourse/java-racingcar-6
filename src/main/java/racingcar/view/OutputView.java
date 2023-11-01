package racingcar.view;

import static racingcar.messages.ViewMessage.MOVEMENT;
import static racingcar.messages.ViewMessage.OUTPUT_CAR_RESULT;
import static racingcar.messages.ViewMessage.OUTPUT_RESULT;

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

    public void printMovementResult(Car car) {
        System.out.printf(OUTPUT_CAR_RESULT, car.getName(), MOVEMENT.repeat(car.getMoveCount()));
    }
}
