package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;
import racingcar.service.RacingCarGameService;

import java.util.List;
import java.util.Map;

public class RacingCarGameController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final RacingCarGameService racingCarGameService;

    public RacingCarGameController(InputHandler inputHandler, OutputHandler outputHandler, RacingCarGameService racingCarGameService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.racingCarGameService = racingCarGameService;
    }

    public void run() {
        RacingCars racingCars = loadCarNames();
        TryCount tryCount = loadTryCount();

        generateRacingCarGroup(racingCars);

        playGame(tryCount);
    }

    public RacingCars loadCarNames() {
        outputHandler.printInputCarNameMessage();
        List<String> carNames = inputHandler.inputCarNames();

        return new RacingCars(carNames);
    }

    public TryCount loadTryCount() {
        outputHandler.printInputTryCountMessage();
        int tryCount = inputHandler.inputTryCount();

        return new TryCount(tryCount);
    }

    public void generateRacingCarGroup(RacingCars racingCars) {
        racingCarGameService.generateRacingCarGroup(racingCars);
    }

    public void playGame(TryCount tryCount) {
        outputHandler.printGameResultMessage();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            racingCarGameService.racingCarGameProgress();
            List<Map<String, String>> stageGameResult = racingCarGameService.racingCarGameResult();
        }
    }
}
