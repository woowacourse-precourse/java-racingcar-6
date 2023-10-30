package racingcar.controller;

import racingcar.dto.RaceResult;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        initGame();
        executeRacing();
        announceWinner();
    }

    private void initGame() {
        List<String> carNames = InputView.inputStringsByDelimiter();
        gameService.initCars(carNames);
    }

    private void executeRacing() {
        int raceCount = InputView.inputNumber();
        List<RaceResult> raceResults = gameService.race(raceCount);
        OutputView.printRaceResult(raceResults);
    }

    private void announceWinner() {
        List<String> winners = gameService.getWinners();
        OutputView.printWinners(winners);
    }
}
