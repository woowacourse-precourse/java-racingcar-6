package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    InputView inputView = new InputView();
    RacingCarService service = new RacingCarService();

    public String userInputCarNames() {
        OutputView.carNameInputMessage();
        return inputView.getUserInput();
    }

    public String userInputTryNumber() {
        OutputView.tryNumberInputMessage();
        return inputView.getUserInput();
    }

    public void racingCar() {
        String userInputCarNames = userInputCarNames();
        String userInputTryNumber = userInputTryNumber();
        Integer tryNumber = service.parsingTryNumber(userInputTryNumber);
        List<String> carNameList = service.createCarNameList(userInputCarNames);
        service.createCarList(carNameList);
        OutputView.racingResultMessage();

        if (tryNumber == 0) {
            OutputView.racingResult(service.raceOneStepResult()+"\n");
        }
        for (int step = 0; step < tryNumber; step++) {
            service.raceOneStep();
            OutputView.racingResult(service.raceOneStepResult()+"\n");
        }

        findWinner();
    }

    private void findWinner() {
        OutputView.winnerMessage(service.findWinnerByCarPosition());
    }
}
