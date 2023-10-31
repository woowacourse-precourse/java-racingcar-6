package racingcar;

import static racingcar.view.RacingGameView.winner;

import java.util.List;
import java.util.Map;
import racingcar.controller.RacingGameController;
import racingcar.view.RacingGameView;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = RacingGameView.inputCarName();
        Map<String, Integer> car = RacingGameController.carNameAndForwardStatus(carNames);

        int intTryCount = RacingGameView.tryCount();

        RacingGameView.gameResultMessage();
        for (int i = 0; i < intTryCount; i++) {
            RacingGameController.moveForward(car);
            RacingGameView.forwardResult(car);
        }

        List<String> mostForwardCarList = RacingGameController.mostMoveForwardCar(car);
        RacingGameView.winnerMessage(winner(mostForwardCarList));
    }
}