package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.validator.InputValidateService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final InputValidateService inputValidateService;
    private final RacingCars racingCars;
    private String tryCount;

    public RacingGameController() {
        outputView = new OutputView();
        inputView = new InputView();
        inputValidateService = new InputValidateService();

        List<Car> racingCarsList = new ArrayList<>();
        racingCars = new RacingCars(racingCarsList);
    }

    public void playGame() {
        setCarName();
        setTryCount();
        iterationRound();
        printFinalWinners();
    }


    public void setCarName() {
        outputView.printCarNameInputMessage();
        try {
            String carName = inputView.inputCarName();
            inputValidateService.validateInputCarName(carName);
            racingCars.generateRacingCars(carName);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void setTryCount() {
        outputView.printTryCountInputMessage();
        try {
            tryCount = inputView.inputTryCount();
            inputValidateService.validateInputTryCount(tryCount);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void iterationRound() {
        System.out.println();
        outputView.printGameResultMessage();
        for (int count = 0; count < Integer.parseInt(tryCount); count++) {
            racingCars.forwardJudge();
            printForwardJudgeResult();
        }
    }

    public void printForwardJudgeResult() {
        List<Map<String, String>> racingCarsInfo = racingCars.getRacingCarsInfo();
        outputView.printRoundResult(racingCarsInfo);
    }

    public void printFinalWinners() {
        List<String> finalWinners = racingCars.winnersJudge();
        outputView.printWinnerResult(finalWinners);
    }
}
