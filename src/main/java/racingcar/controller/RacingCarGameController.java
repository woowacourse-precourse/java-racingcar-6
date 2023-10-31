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
    private Cars cars;

    public void playRacingCarGame() {
        OutputView.printInputCarsNameMessage();

        List<Name> namesOfCars = Utils.splitNamesOfCars(InputView.inputCarsNamesOfCars());
        List<Car> carList = CarFactory.generateCar(namesOfCars);
        cars = new Cars(carList);

        OutputView.printInputNumberOfMovesMessage();
        int numberOfMoves = InputView.inputNumberOfMoves();

        for (int i = 0; i < numberOfMoves; i++) {
            List<Car> movedCars = cars.moveCars(randomNumberGenerator);
            OutputView.printCurrentLocations(movedCars);
        }

        String winnerNamesOfCars = cars.findWinnerCars();

        OutputView.printWinnerNames(winnerNamesOfCars);
    }
}
