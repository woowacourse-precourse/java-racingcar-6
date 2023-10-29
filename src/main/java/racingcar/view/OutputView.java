package racingcar.view;

import racingcar.constant.GameMessage;
import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public void printResultMsg() {
        System.out.println(GameMessage.GAME_RESULT_MESSAGE);
    }

    public void printWinner(String winner) {
        System.out.printf(GameMessage.GAME_WINNER_MESSAGE, winner);
    }

    public void printEachRaceResult(List<Car> raceResult) {
        for(Car car : raceResult) {
            printEachRaceCarResult(car);
        }
        System.out.println();
    }

    public void printEachRaceCarResult(Car car) {
        System.out.printf(GameMessage.EACH_MOVE_RESULT_MESSAGE, car.getName(),
                GameMessage.DASH.repeat(car.getDist()));
    }
}
