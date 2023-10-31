package racingcar.controller;

import java.util.List;
import racingcar.model.NCars;

public class GameController {
    IOController ioController;

    private GameController() {
        this.ioController = new IOController();
    }

    public static GameController startGame() {
        return new GameController();
    }

    public void processGame() {
        ioController.showIntroMessage();
        List<String> names = ioController.getCarNames();
        NCars nCars = NCars.applyNames(names);
        ioController.showRequestRoundNumberMessage();
        int round = ioController.getRoundNumber();
        for (int i = 0; i < round; i++) {
            nCars.moveCars();
            ioController.showRoundResult(nCars.getSingleRoundResult());
        }
        ioController.showWinner(nCars.getWinnerName());
    }
}
