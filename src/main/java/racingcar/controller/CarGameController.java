package racingcar.controller;

import racingcar.domain.wrapper.TryCount;
import racingcar.domain.wrapper.CarNames;
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
        CarNames carNames = loadCarNames();

        generateStatusGroup(carNames);

        TryCount tryCount = loadTryCount();

        playGame(tryCount);

        finalWinners();
    }

    private CarNames loadCarNames() {
        outputHandler.printInputCarNameMessage();
        List<String> carNames = inputHandler.inputCarNames();

        return CarNames.create(carNames);
    }

    private TryCount loadTryCount() {
        outputHandler.printInputTryCountMessage();
        String tryCount = inputHandler.inputTryCount();

        return TryCount.create(tryCount);
    }

    private void generateStatusGroup(CarNames carNames) {
        carGameService.generateStatusGroup(carNames);
    }

    private void playGame(TryCount tryCount) {
        outputHandler.printGameResultMessage();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            carGameService.carGameProgress();
            gameResult();
        }
    }

    private void gameResult() {
        List<Map<String, String>> stageGameResults = carGameService.carGameResult();
        outputHandler.printGameProgress(stageGameResults);
    }

    private void finalWinners() {
        String winners = carGameService.getWinnerNames();
        outputHandler.printFinalWinners(winners);
    }
}
