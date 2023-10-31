package racingcar.controller;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(final InputView inputView, final OutputView outputView, final GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        Cars cars = createCarsByNames(getNames());
        int trialCount = getTrialCount();

        playRounds(trialCount, cars);
        printWinnersName(cars);
    }

    private String getNames() {
        outputView.printNamesGuide();
        return inputView.readInput();
    }

    private Cars createCarsByNames(final String names) {
        return gameService.createCars(names);
    }

    private int getTrialCount() {
        outputView.printTrialGuide();
        return gameService.createTrialCount(inputView.readInput());
    }

    private void playRounds(final int trialCount, final Cars cars) {
        outputView.printResultGuide();
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
        outputView.printRoundResult(roundResult);
    }

    private void printWinnersName(final Cars cars) {
        List<String> winnersName = gameService.findWinnersName(cars);
        outputView.printWinnersName(winnersName);
    }

}
