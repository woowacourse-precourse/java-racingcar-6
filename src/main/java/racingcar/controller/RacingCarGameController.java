package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Cars;
import racingcar.model.Name;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void playRacingCarGame() {
        OutputView.printInputCarsNameMessage();

        List<Name> namesOfCars = Utils.splitNamesOfCars(InputView.inputCarsNamesOfCars());
        List<Car> carList = CarFactory.generateCar(namesOfCars);
        Cars cars = new Cars(carList);

        OutputView.printInputNumberOfMovesMessage();
        int numberOfMoves = InputView.inputNumberOfMoves();

        for (int moveCount = 0; moveCount < numberOfMoves; moveCount++) {
            List<Car> movedCars = cars.move(randomNumberGenerator);
            OutputView.printCurrentLocations(movedCars);
        }

        String winnerNamesOfCars = cars.findWinners();

        OutputView.printWinnerNames(winnerNamesOfCars);
    }
}
