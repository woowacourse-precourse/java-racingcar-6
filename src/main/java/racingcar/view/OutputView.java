package racingcar.view;

import racingcar.constant.GameMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GameMessage.START_GAME);
    }

    public void printRepeatNumberMessage() {
        System.out.println(GameMessage.REPEAT_NUMBER_REQUEST);
    }
}
