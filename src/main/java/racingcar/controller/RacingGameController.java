package racingcar.controller;

import racingcar.dto.TotalResult;
import racingcar.dto.Winners;
import racingcar.service.RacingGameService;
import racingcar.view.View;

public class RacingGameController {
    private final View view;
    private final RacingGameService racingGameService;

    public RacingGameController(View view, RacingGameService racingGameService) {
        this.view = view;
        this.racingGameService = racingGameService;
    }

    public void start() {
        generateCars();
        setAttemptCount();
        playRounds();
        printWinners();
    }

    private void generateCars() {
        racingGameService.generateCars(inputCarsName());
    }

    private String inputCarsName() {
        return view.inputCarsName();
    }

    private void setAttemptCount() {
        racingGameService.setAttemptCount(inputAttemptCount());
    }

    private String inputAttemptCount() {
        return view.inputAttemptCount();
    }

    private void playRounds() {
        printTotalResult(racingGameService.playRounds());
    }

    private void printTotalResult(TotalResult totalResult) {
        view.printTotalResult(totalResult);
    }

    private void printWinners() {
        view.printFinalWinnerMessage(getWinners());
    }

    private Winners getWinners() {
        return racingGameService.getWinners();
    }
}