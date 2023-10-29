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
        Cars cars = makeCars();
        int trialCount = getTrialCount();

        playRounds(trialCount, cars);
        printWinnersName(cars);
    }

    private Cars makeCars() {
        outputView.printNamesGuide();
        String carNames = inputView.readCarNames();
        return gameService.createCars(carNames);
    }

    private int getTrialCount() {
        outputView.printTrialGuide();
        String trialCount = inputView.readTrialNumber();
        return gameService.createTrialCount(trialCount);
    }

    private void playRounds(final int trialCount, final Cars cars) {
        outputView.printResultGuide();
        for (int round = 0; round < trialCount; round++) {
            CarsDto carsDto = gameService.playRound(cars);
            outputView.printRoundResult(carsDto);
        }
    }

    private void printWinnersName(final Cars cars) {
        List<String> winnersName = gameService.findWinnersName(cars);
        outputView.printWinnersName(winnersName);
    }

}
