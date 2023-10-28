package racingcar.view;

import racingcar.constant.OutputMessage;
import racingcar.domain.Cars;

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
}
