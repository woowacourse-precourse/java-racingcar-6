package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.vehicle.Cars;

public final class GameController {
    private Cars cars;
    private final IOController ioController;

    private GameController(Cars cars, IOController ioController) {
        this.cars = cars;
        this.ioController = ioController;
    }

    public static GameController startGame(Cars cars, IOController ioController) {
        return new GameController(cars, ioController);
    }

    public void setUpCars() {
        ioController.showIntroMessage();
        List<String> names = ioController.getCarNames();
        this.cars = cars.applyNames(names);
    }

    public void processGame() {
        setUpCars();
        int round = getRoundNumber();
        moveCarsByGivenRoundNumber(round);
        ioController.showWinner(cars.getWinnerName());
    }

    public int getRoundNumber() {
        ioController.showRequestRoundNumberMessage();
        return ioController.getRoundNumber();
    }

    private void moveCarsByGivenRoundNumber(final int round) {
        IntStream.range(0, round).forEach(i -> {
            cars.moveCars();
            ioController.showRoundResult(cars.getSingleRoundResult());
        });
    }

}
