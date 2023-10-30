package racingcar.view;

import racingcar.constant.GameMessage;
import racingcar.domain.Cars;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GameMessage.START_GAME);
    }

    public void printRepeatNumberMessage() {
        System.out.println(GameMessage.REPEAT_NUMBER_REQUEST);
    }

    public void printGameStatus(Cars cars) {
        System.out.println(GameMessage.EXECUTION_RESULT);

    }

}
