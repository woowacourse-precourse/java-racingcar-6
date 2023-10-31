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
        int tryTimes = inputView.getTrytimes();
        WinnersDto winnersDto = printGameResult(cars, tryTimes);
        outputView.printWinner(winnersDto);
    }

    private WinnersDto printGameResult(Cars cars, int tryTimes) {
        outputView.printGameResultMsg();
        for (int i = 0; i < tryTimes; i++) {
            cars.moveCarsBy(movePossibilityChecker);
            CarsDto carsDto = cars.toCarsDto();
            outputView.printGameResult(carsDto);
        }
        return cars.toCarsDto().getWinners();
    }
}
