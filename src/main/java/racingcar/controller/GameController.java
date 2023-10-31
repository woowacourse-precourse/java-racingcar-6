package racingcar.controller;

import racingcar.dto.RaceResult;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        initGame();
        executeRacing();
        announceWinner();
    }

    private void initGame() {
        List<String> carNames = inputView.inputCarNames();
        gameService.initCars(carNames);
    }

    private void executeRacing() {
        int raceCount = inputView.inputRaceCount();
        List<RaceResult> raceResults = gameService.race(raceCount);
        outputView.printRaceResult(raceResults);
    }

    private void announceWinner() {
        List<String> winners = gameService.getWinners();
        outputView.printWinners(winners);
    }
}
