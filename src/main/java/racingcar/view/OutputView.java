package racingcar.view;

import racingcar.constant.OutputMessage;
import racingcar.domain.Cars;
import racingcar.domain.Names;

public class OutputView {

    public void printNameMessage() {
        System.out.println(OutputMessage.READ_NAME.getMessage());
    }

    public void printTryCountMessage() {
        System.out.println(OutputMessage.READ_TRY_COUNT.getMessage());
    }

    public void printRacingResult(Cars cars) {
        System.out.println(cars.getRacingResult());
    }

    public void printResultMessage() {
        System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
    }

    public void printWinner(Names winner) {
        OutputMessage winnerMessage = OutputMessage.WINNER;
        System.out.printf(winnerMessage.getMessage(), winner.getElements());
        System.out.println();
    }
}
