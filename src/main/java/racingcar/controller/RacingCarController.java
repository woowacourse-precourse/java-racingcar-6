package racingcar.controller;

import racingcar.model.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private InputView inputView;
    private RacingCarService service;

    public RacingCarController(InputView inputView, RacingCarService service) {
        this.inputView = inputView;
        this.service = service;
    }

    public String userInputCarNames() {
        OutputView.carNameInputMessage();
        return inputView.getUserInput();
    }

    public String userInputTryNumber() {
        OutputView.tryNumberInputMessage();
        return inputView.getUserInput();
    }

    public void racing() {
        String userInputCarNames = userInputCarNames();
        String userInputTryNumber = userInputTryNumber();
        Integer tryNumber = service.parsingTryNumber(userInputTryNumber);
        service.createCarList(userInputCarNames);
        OutputView.racingResultMessage();

        if (tryNumber == 0) {
            OutputView.racingResult(service.racingResult());
        }
        for (int step = 0; step < tryNumber; step++) {
            service.move();
            OutputView.racingResult(service.racingResult());
        }

        findWinner();
    }

    private void findWinner() {
        OutputView.winnerMessage(service.findWinner());
    }
}
