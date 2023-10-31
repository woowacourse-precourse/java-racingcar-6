package racingcar;

import java.util.HashMap;
import java.util.List;

import racingcar.controller.RacingGameController;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }
}

class Game {
    public void init() {
        String carName = RacingGameView.inputCarName();

        HashMap<String, String> car = RacingGameController.carNameAndForwardStatus(carName);

        int tryCount = RacingGameView.inputTryCount();

        RacingGameView.gameResultMessage();
        for (int i = 0; i < tryCount; i++) {
            RacingGameController.moveForward(car);
            RacingGameView.forwardResult(car);
        }

        List<String> mostForwardCarList = RacingGameController.mostMoveForwardCar(car);
        RacingGameView.winner(mostForwardCarList);
    }
}