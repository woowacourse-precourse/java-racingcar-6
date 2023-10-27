package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    InputView input = new InputView();
    OutputView output = new OutputView();

    public void play() {
        Cars cars = createCars();
        int totalRound = input.totalRound();
        race(cars, totalRound);
        selectWinner(cars);
    }

    private void race(Cars cars, int totalRound) {
        output.printResultGuideMessage();
        for(int currentRound=0; currentRound<totalRound; currentRound++) {
            proceedCurrentRound(cars);
            output.printRoundSeparator();
        }
    }

    private void proceedCurrentRound(Cars cars) {
        for(Car car : cars) {
            car.randomMove();
            output.printMoveRecord(car.getName(), car.getMoveDistance());
        }
    }

    private void selectWinner(Cars cars) {
        output.printWinners(cars.getWinnersName());
    }

    private Cars createCars() {
        return new Cars(input.carsName());
    }
}
