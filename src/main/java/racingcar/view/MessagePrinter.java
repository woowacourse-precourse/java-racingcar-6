package racingcar.view;

import racingcar.RacingCar;

import java.util.List;

import static racingcar.constant.NumberConstant.MIN_WINNER_SIZE;
import static racingcar.constant.NumberConstant.ONE;
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

    public void printWinnerMessage() {
        System.out.print(FINAL_WINNER_MESSAGE);
    }

    public void printExecutionResult(final List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            String carName = racingCar.getCarName();
            String currentLocation = racingCar.getCurrentLocation();
            System.out.println(carName + COLON + currentLocation);
        });
        System.out.println(BLANK);
    }

    public void printWinners(final List<RacingCar> winners) {
        StringBuilder result = new StringBuilder();
        int maxWinnerSize = winners.size() - ONE;

        winners.forEach(winner -> {
            result.append(winner.getCarName());
            if (winners.indexOf(winner) != maxWinnerSize) {
                result.append(COMMA_BLANK);
            }
        });

        System.out.println(result);
    }
}
