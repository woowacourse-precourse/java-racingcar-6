package racingcar.view;

import racingcar.domain.Cars;
import racingcar.util.Message;

public class OutputView {
    public OutputView() {
    }
    
    public void printRacingResult() {
        Message.printRacingResultMessage();
    }

    public void printMoveResult(Cars cars) {
        Message.printMoveResultMessage(cars.getCarList());
    }

    public void printRacingWinner(Cars cars) {
        String winner = String.join(", ", cars.getWinner());
        Message.printRacingWinnerMessage(winner);
    }
}
