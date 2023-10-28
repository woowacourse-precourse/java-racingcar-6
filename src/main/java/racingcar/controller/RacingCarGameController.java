package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;
import racingcar.service.RacingCarGameService;

import java.util.List;

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
}
