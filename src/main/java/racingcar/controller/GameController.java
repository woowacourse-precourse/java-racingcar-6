package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MovePossibilityChecker;
import racingcar.domain.dto.output.CarsDto;
import racingcar.domain.dto.output.WinnersDto;
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
        WinnersDto winnersDto = playAllRounds(cars);
        outputView.printWinner(winnersDto);
    }

    private WinnersDto playAllRounds(Cars cars) {
        int tryTimes = inputView.getTrytimes();
        outputView.printGameResultMsg();
        for (int i = 0; i < tryTimes; i++) {
            playRound(cars);
        }
        return cars.toCarsDto().getWinners();
    }

    private void playRound(Cars cars) {
        cars.moveCarsBy(movePossibilityChecker);
        CarsDto carsDto = cars.toCarsDto();
        outputView.printGameResult(carsDto);
    }
}
