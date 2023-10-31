package racingcar.controller;

import racingcar.model.Information;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static RacingController racingController;

    public GameController(InputView inputView) {
        if (racingController == null) {
            racingController = new RacingController(inputView.getInformation());
        }
    }

    public void runGame() {
        playGame();
        outWinner();
    }

    private void playGame() {
        //TODO : print start message;
        for (int i = 0; i < racingController.times; i++) {
            playRound();
        }
    }

    private void playRound() {
        racingController.go();
        //TODO : print result(racingCars.getResult)
    }

    private void outWinner() {
        RacingCars winners = RacingCars.from(racingController.getMaxs());
        //TODO : print winners
    }
}
