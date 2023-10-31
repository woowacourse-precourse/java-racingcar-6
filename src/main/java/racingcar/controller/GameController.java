package racingcar.controller;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService;

    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        Cars cars = createCarsByNames(getNames());
        int trialCount = createTrialCount(getTrialCount());

        playRounds(trialCount, cars);
        printWinnersName(cars);
    }

    private String getNames() {
        OutputView.printNamesGuide();
        return InputView.readInput();
    }

    private Cars createCarsByNames(final String names) {
        return gameService.createCars(names);
    }

    private String getTrialCount() {
        OutputView.printTrialGuide();
        return InputView.readInput();
    }

    private int createTrialCount(final String trialCount) {
        return gameService.createTrialCount(trialCount);
    }

    private void playRounds(final int trialCount, final Cars cars) {
        OutputView.printResultGuide();
        for (int round = 0; round < trialCount; round++) {
            playOneRound(cars);
        }
    }

    private void playOneRound(final Cars cars) {
        gameService.moveCars(cars);
        printRoundResult(cars);
    }

    private void printRoundResult(final Cars cars) {
        CarsDto roundResult = gameService.getRoundResult(cars);
        OutputView.printRoundResult(roundResult);
    }

    private void printWinnersName(final Cars cars) {
        List<String> winnersName = gameService.findWinnersName(cars);
        OutputView.printWinnersName(winnersName);
    }

}
