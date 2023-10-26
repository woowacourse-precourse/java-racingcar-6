package racingcar.view;

import racingcar.RacingCar;

import java.util.List;

import static racingcar.constant.TextConstant.*;

public class MessagePrinter {

    public void printCarNameInputMessage() {
        System.out.println(RACING_CAR_NAME_INPUT_MESSAGE);
    }

    public void printAttemptCountInputMessage() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
    }

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printExecutionResult(final List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            String carName = racingCar.getCarName();
            String currentLocation = racingCar.getCurrentLocation();
            System.out.println(carName + COLON + currentLocation);
        });
        System.out.println(BLANK);
    }
}
