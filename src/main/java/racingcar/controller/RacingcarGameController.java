package racingcar.controller;

import java.util.List;
import racingcar.service.CarService;
import racingcar.service.RacingcarGameService;
import racingcar.view.TextInterface;

public class RacingcarGameController {
    private final RacingcarGameService racingcarGameService = new RacingcarGameService();
    private final CarService carService = new CarService();
    private final TextInterface textInterface = new TextInterface();

    public void runGame() {
        initGame();
        startGame();
        endGame();
    }

    private void initGame() {
        textInterface.askCarNames();
        List<String> carNames = racingcarGameService.getCarNames();
        carService.initCars(carNames);
        textInterface.askRacingcarRound();
        racingcarGameService.getRoundNumber();
        System.out.println();
    }

    private void startGame() {
        textInterface.startRound();
        carService.runRounds(racingcarGameService.getRoundTimes());
    }

    private void endGame() {
        textInterface.printResult(carService.getResult());
    }
}
