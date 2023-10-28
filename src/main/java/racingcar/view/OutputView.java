package racingcar.view;

import static racingcar.message.MessageConstants.RUN_RESULT_MESSAGE;
import static racingcar.message.MessageConstants.WINNER_MESSAGE;

import racingcar.domain.Cars;

public class OutputView {
    public void runResultMessage() {
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public void winnerCarsMessage(Cars cars) {
        System.out.printf(WINNER_MESSAGE, cars.winnerCars());
    }
}
