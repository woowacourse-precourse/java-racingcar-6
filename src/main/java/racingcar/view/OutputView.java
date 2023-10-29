package racingcar.view;

import racingcar.constant.GameMessage;
import racingcar.domain.Car;

public class OutputView {
    public void printResultMsg() {
        System.out.println(GameMessage.GAME_RESULT_MESSAGE);
    }

    public void printWinner(Car winner) {
        System.out.printf(GameMessage.GAME_WINNER_MESSAGE, winner.getName());
    }

    public void printEachRaceResult(Car car) {
        System.out.printf(GameMessage.EACH_MOVE_RESULT_MESSAGE, car.getName(),
                GameMessage.DASH.repeat(car.getDist()));
    }
}
