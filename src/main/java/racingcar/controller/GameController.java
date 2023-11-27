package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarNamesWithDistanceDto;
import racingcar.dto.WinnerNamesDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playGame() {
        Cars cars = initCars();
        int trialTimes = getTrialTimes();

        executeGame(cars, trialTimes);

        showGameResult(cars);
    }

    private Cars initCars() {
        List<String> carNames = getCarNames();
        return Cars.from(carNames.stream()
                .map(Car::from)
                .toList());
    }

    private List<String> getCarNames() {
        outputView.askToInsertCarNameList();
        return inputView.getCarNames();
    }

    private int getTrialTimes() {
        outputView.askToInsertTrialTimes();
        return inputView.getTrialTimes();
    }

    private void executeGame(Cars cars, final int trialTimes) {
        outputView.printExecutionStartSign();
        for (int i = 0; i < trialTimes; i++) {
            cars.race();
            printEachCarStatus(CarNamesWithDistanceDto.from(cars.getCarNamesWithDistance()));
        }
    }

    private void printEachCarStatus(CarNamesWithDistanceDto carNamesWithDistanceDto) {
        outputView.printCarStatus(carNamesWithDistanceDto);
    }

    private void showGameResult(Cars cars) {
        outputView.printFinalWinner(WinnerNamesDto.from(cars.findWinners()));
    }
}