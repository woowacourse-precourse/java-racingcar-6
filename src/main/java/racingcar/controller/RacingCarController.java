package racingcar.controller;

import java.util.List;
import racingcar.service.InputOutputService;
import racingcar.service.RacingCarService;
import racingcar.view.TextInterface;

public class RacingCarController {
    private final InputOutputService inputOutputService = new InputOutputService();
    private final RacingCarService racingCarService = new RacingCarService();
    private final TextInterface textInterface = new TextInterface();

    public void runGame() {
        initGame();
        startGame();
        endGame();
    }

    private void initGame() {
        textInterface.askCarNames();
        List<String> carNames = inputOutputService.getCarName();
        racingCarService.initCars(carNames);

        textInterface.askRacingcarRound();
        int roundNumber = inputOutputService.getRoundNumber();
        racingCarService.initRoundNumber(roundNumber);

        System.out.println();
    }

    private void startGame() {
        textInterface.startRound();
        racingCarService.runRounds();
    }

    private void endGame() {
        List<String> winners = racingCarService.getWinnersName();
        textInterface.printResult(winners);
    }
}
