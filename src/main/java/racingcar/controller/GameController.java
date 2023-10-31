package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveChecker;
import racingcar.domain.dto.output.CarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MoveChecker moveChecker;

    public GameController(InputView inputView, OutputView outputView, MoveChecker moveChecker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveChecker = moveChecker;
    }

    public void start() {
        Cars cars = inputView.getCars();
        playAllRounds(cars);
        outputView.printWinner(cars.toWinnersDto());
    }

    private void playAllRounds(Cars cars) {
        int tryTimes = inputView.getTryTimes();
        for (int i = 0; i < tryTimes; i++) {
            playRound(cars);
        }
    }

    private void playRound(Cars cars) {
        cars.moveCarsBy(moveChecker);
        CarsDto carsDto = cars.toCarsDto();
        outputView.printGameResult(carsDto);
    }
}
