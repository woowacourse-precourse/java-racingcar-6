package racingcar.controller;

import racingcar.domain.Cars;
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
        Cars cars = loadCarNames();
        TryCount tryCount = loadTryCount();

        generateRacingCarGroup(cars);

        playGame(tryCount);

        finalWinners();
    }

    public Cars loadCarNames() {
        outputHandler.printInputCarNameMessage();
        List<String> carNames = inputHandler.inputCarNames();

        return new Cars(carNames);
    }

    public TryCount loadTryCount() {
        outputHandler.printInputTryCountMessage();
        int tryCount = inputHandler.inputTryCount();

        return new TryCount(tryCount);
    }

    public void generateRacingCarGroup(Cars cars) {
        carGameService.generateRacingCarGroup(cars);
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
