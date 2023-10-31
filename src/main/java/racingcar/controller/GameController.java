package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MovePossibilityChecker;
import racingcar.domain.dto.output.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovePossibilityChecker movePossibilityChecker;

    public GameController(InputView inputView, OutputView outputView, MovePossibilityChecker movePossibilityChecker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movePossibilityChecker = movePossibilityChecker;
    }

    public void start() {
        Cars cars = inputView.getCars();
        playAllRounds(cars);
        outputView.printWinner(cars.toWinnersDto());
    }

    private void playAllRounds(Cars cars) {
        int tryTimes = inputView.getTrytimes();
        for (int i = 0; i < tryTimes; i++) {
            playRound(cars);
        }
    }

    private void playRound(Cars cars) {
        cars.moveCarsBy(movePossibilityChecker);
        CarsDto carsDto = cars.toCarsDto();
        outputView.printGameResult(carsDto);
    }
}
