package racingcar.view;

/*
 *  사용자에게 진행상황과 요청사항을 알려주는 담당
 * */

import racingcar.constant.GameMessage;

public class OutputView {
    private final GameMessage gameMessage = new GameMessage();

    public void requestCarName() {
        System.out.println(gameMessage.REQUEST_CAR_NAME);
    }

    public void requestMoveCount() {
        System.out.println(gameMessage.REQUEST_MOVE_COUNT);
    }
}
