package racingcar;

import java.util.HashMap;
import java.util.List;

import racingcar.controller.RacingGameController;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        racingGame();
    }

    private static void racingGame() {
        String carName = RacingGameView.inputCarName();
        int tryCount = RacingGameView.inputTryCount();

        HashMap<String, String> carStatus = RacingGameController.carNameAndForwardStatus(carName);

        for (int i = 0; i < tryCount; i++) {
            RacingGameController.referee(carStatus);
            RacingGameView.moveStatus(carStatus);
        }

        List<String> mostForwardCar = RacingGameController.mostMovingForwardCar(carStatus);
        RacingGameView.winner(mostForwardCar);
    }
}
