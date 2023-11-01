package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Cars cars;
    public void start() {
        initializeCars();
        int numberOfMoves = InputView.getNumberOfMovesFromUser();
        race(numberOfMoves);
        printWinners();
    }

    private void initializeCars() {
        String[] carNames = InputView.getCarNamesFromUser();
        cars = new Cars(carNames);
    }

    private void race(int numberOfMoves) {
        for(int i = 0; i < numberOfMoves; i++) {
            runOneRound();
        }
    }

    private void runOneRound() {
        cars.moveCars();
        OutputView.printEachForwardResult(cars.getCars());
    }

    private void printWinners() {
        List<Car> winners = cars.getWinnerCars();
        OutputView.printWinners(winners);
    }
}
