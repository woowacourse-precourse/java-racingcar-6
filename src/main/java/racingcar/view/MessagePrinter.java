package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarRace;

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
        System.out.println(BLANK);
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
        String result = RacingCarRace.concatCarNames(winners);

        System.out.println(result);
    }
}
