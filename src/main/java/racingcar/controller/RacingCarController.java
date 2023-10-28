package racingcar.controller;

import java.util.List;
import racingcar.handler.InputHandler;
import racingcar.model.GameResult;
import racingcar.service.RacingCarService;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputHandler inputHandler, OutputView outputView, RacingCarService racingCarService) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        GameResult gameResult = gameStart();
        winnerDeclaration(gameResult);
    }

    GameResult gameStart() {
        outputView.printGameStartConsole();
        List<String> carNames = inputHandler.handleCarNamesInput();

        outputView.printRaceTimeInfoConsole();
        int raceTime = inputHandler.handleRaceTimeInput();

        return racingCarService.race(carNames, raceTime);
    }

    void winnerDeclaration(GameResult gameResult) {

    }
}
