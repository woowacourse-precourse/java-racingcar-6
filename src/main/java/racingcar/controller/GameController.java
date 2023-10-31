package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.NCars;

public final class GameController {
    NCars nCars;
    IOController ioController;

    private GameController() {
        this.ioController = new IOController();
    }

    public static GameController startGame() {
        return new GameController();
    }

    public void setUpCars() {
        ioController.showIntroMessage();
        List<String> names = ioController.getCarNames();
        this.nCars = NCars.applyNames(names);
    }

    public void processGame() {
        setUpCars();
        int round = getRoundNumber();
        moveCarsByGivenRoundNumber(round);
        ioController.showWinner(nCars.getWinnerName());
    }

    public int getRoundNumber() {
        ioController.showRequestRoundNumberMessage();
        return ioController.getRoundNumber();
    }

    private void moveCarsByGivenRoundNumber(final int round) {
        IntStream.range(0, round).forEach(i -> {
            nCars.moveCars();
            ioController.showRoundResult(nCars.getSingleRoundResult());
        });
    }

}
