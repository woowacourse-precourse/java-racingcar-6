package racingcar.view;

/*
 *  사용자에게 진행상황과 요청사항을 알려주는 담당
 * */

import racingcar.domain.Car;
import racingcar.domain.GamePlayer;
import racingcar.domain.GameWinner;

public class OutputView {
    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String BEFORE_MOVE_MESSAGE = "실행 결과";
    private static final String WINNER_DEFAULT_MESSAGE = "최종 우승자 : ";
    private static final String MOVE_SIGN = "-";
    
    public void requestCarName() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
    }

    public void requestMoveCount() {
        System.out.println(REQUEST_MOVE_COUNT_MESSAGE);
    }

    public void moveResult(GamePlayer gamePlayer) {
        for (Car car : gamePlayer.getCars()) {
            System.out.println(car.getName() + " : " + MOVE_SIGN.repeat(car.getMoveDistance()));
        }
        System.out.println();
    }

    public void beforeMovingMessage() {
        System.out.println(BEFORE_MOVE_MESSAGE);
    }

    public void gameWinner(GameWinner gameWinner) {
        System.out.print(WINNER_DEFAULT_MESSAGE + gameWinner.getNames());
    }
}
