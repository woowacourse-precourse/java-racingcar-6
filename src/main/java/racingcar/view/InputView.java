package racingcar.view;

import racingcar.constant.GameMessage;

public class InputView {

    public void requestCarName() {
        System.out.println(GameMessage.GAME_START_MESSAGE);
    }

    public void requestMoveCnt() {
        System.out.println(GameMessage.GAME_MOVE_CNT_MESSAGE);
    }
}
