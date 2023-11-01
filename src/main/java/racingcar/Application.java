package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
            RacingGameModel racingGameModel = new RacingGameModel();
            RacingGameView racingGameView = new RacingGameView();
            RacingGameController racingGameController = new RacingGameController(racingGameView, racingGameModel);

            racingGameController.playGame();
        }
    }

