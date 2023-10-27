package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.CarRacingGameService;
import racingcar.util.ConsoleIO;

public class CarRacingGameController {
    private final CarRacingGameService carRacingGameService;

    public CarRacingGameController() {
        carRacingGameService = new CarRacingGameService();
    }

    public void run() {
        Car cars = carRacingGameService.getCar(ConsoleIO.readCarName());

        Game game = carRacingGameService.getGame(cars, ConsoleIO.readGameSet());

        playGame(game);
    }

    private void playGame(Game game) {
        ConsoleIO.printPlayResultMessage();

        while (carRacingGameService.isContinue(game)) {
            ConsoleIO.printSetResult(carRacingGameService.playSet(game));
        }

        ConsoleIO.printFinalResult(carRacingGameService.getFinalResult(game));
    }
}
