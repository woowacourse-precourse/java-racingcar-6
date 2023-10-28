package racingcar.view;

import racingcar.RacingCar;
import racingcar.RacingCarRace;

import java.util.List;

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

    public void printExecutionResult(final RacingCarRace racingCarRace) {
        List<RacingCar> racingCars = racingCarRace.getRacingCars();

        for (RacingCar racingCar : racingCars) {
            String carName = racingCar.getCarName();
            String currentLocation = racingCar.getCurrentLocation();
            System.out.println(carName + COLON + currentLocation);
        }

        System.out.println(BLANK);
    }

    public void printWinners(final RacingCarRace racingCarRace) {
        List<RacingCar> winners = racingCarRace.findWinners();
        StringBuilder result = new StringBuilder();
        int maxWinnerIdx = winners.size() - ONE;

        for (RacingCar winner : winners) {
            result.append(winner.getCarName());
            if (winners.indexOf(winner) != maxWinnerIdx) {
                result.append(COMMA_BLANK);
            }
        }

        System.out.println(result);
    }
}
