package racingcar.controller;

import racingcar.model.Information;
import racingcar.view.InputView;

public class GameController {
    private static RacingController racingController;

    public GameController(InputView inputView) {
        if (racingController == null) {
            racingController = new RacingController(inputView.getInformation());
        }
    }

    public static void runGame() {
        playGame();
        outWinner();
    }

    private static void playGame() {
        //TODO : print start message;
        for (int i = 0; i < racingController.times; i++) {
            playRound();
        }
    }

    private static void playRound() {
        racingController.go();
        //TODO : print result(racingCars.getResult)
    }

    private static void outWinner() {
    }
}
