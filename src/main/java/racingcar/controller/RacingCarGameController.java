package racingcar.controller;

import racingcar.domain.RacingCar;
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
        RacingCar racingCar = loadCarNames();
        TryCount tryCount = loadTryCount();
        generateRacingCarGroup(racingCar);
    }

    public RacingCar loadCarNames() {
        outputHandler.printInputCarNameMessage();
        List<String> carNames = inputHandler.inputCarNames();

        return new RacingCar(carNames);
    }

    public TryCount loadTryCount() {
        outputHandler.printInputTryCountMessage();
        int tryCount = inputHandler.inputTryCount();

        return new TryCount(tryCount);
    }

    public void generateRacingCarGroup(RacingCar racingCar) {
        racingCarGameService.generateRacingCarGroup(racingCar);
    }
}
