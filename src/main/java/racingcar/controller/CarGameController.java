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

    public CarNames loadCarNames() {
        outputHandler.printInputCarNameMessage();
        List<String> carNames = inputHandler.inputCarNames();

        return CarNames.create(carNames);
    }

    public TryCount loadTryCount() {
        outputHandler.printInputTryCountMessage();
        String tryCount = inputHandler.inputTryCount();

        return TryCount.create(tryCount);
    }

    public void generateStatusGroup(CarNames carNames) {
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
