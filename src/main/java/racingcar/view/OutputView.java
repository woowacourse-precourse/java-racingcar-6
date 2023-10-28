package racingcar.view;

import racingcar.constant.OutputMessage;
import racingcar.domain.Cars;

import java.util.List;

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

    public void printWinner(List<String> winner) {
        OutputMessage winnerMessage = OutputMessage.WINNER;
        String winnerNames = String.join(OutputMessage.WINNER_DELIMITER.getMessage(), winner);
        System.out.printf(winnerMessage.getMessage(), winnerNames);
        System.out.println();
    }
}
