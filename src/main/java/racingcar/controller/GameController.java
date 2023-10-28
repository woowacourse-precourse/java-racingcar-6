package racingcar.controller;

import racingcar.dto.CarsGenerateDto;
import racingcar.service.GameService;
import racingcar.view.OutputView;

public class GameController {

    private final InputController inputController;

    private final GameService gameService;

    private final OutputView outputView;

    public GameController(final InputController inputController, final OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
        gameService = new GameService();
    }

    public void play() {
        String[] carNames = inputController.inputCarNames();
        int trialNumber = inputController.inputTrialNumber();

        CarsGenerateDto generatedCars = new CarsGenerateDto(carNames);
        outputView.showResultMessage();

        gameService.playUntilTrialNumber(trialNumber, generatedCars);
    }
}
