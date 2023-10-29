package racingcar.controller;

import racingcar.domain.TryCount;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;
import racingcar.service.CarGameService;

import java.util.List;
import java.util.Map;

public class CarGameController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CarGameService carGameService;

    public CarGameController(InputHandler inputHandler, OutputHandler outputHandler, CarGameService carGameService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.carGameService = carGameService;
    }

    public void run() {
        List<String> carNames = loadCarNames();
        TryCount tryCount = loadTryCount();

        generateRacingCarGroup(carNames);

        playGame(tryCount);

        finalWinners();
    }

    public List<String> loadCarNames() {
        outputHandler.printInputCarNameMessage();
        List<String> carNames = inputHandler.inputCarNames();

        return carNames;
    }

    public TryCount loadTryCount() {
        outputHandler.printInputTryCountMessage();
        int tryCount = inputHandler.inputTryCount();

        return new TryCount(tryCount);
    }

    public void generateRacingCarGroup(List<String> carNames) {
        carGameService.generateRacingCarGroup(carNames);
    }

    public void playGame(TryCount tryCount) {
        outputHandler.printGameResultMessage();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            carGameService.racingCarGameProgress();
            List<Map<String, String>> stageGameResults = carGameService.racingCarGameResult();
            outputHandler.printGameProgress(stageGameResults);
        }
    }

    public void finalWinners() {
        String winners = carGameService.getWinnerNames();
        outputHandler.printFinalWinners(winners);
    }
}
