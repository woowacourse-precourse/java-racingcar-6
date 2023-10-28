package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.Player;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private Cars cars;
    private Player player;

    public void playRacingCarGame() {
        OutputView.printInputCarsNameMessage();
        player = new Player(InputView.inputCarsNamesOfCars());

        List<String> namesOfCars = player.splitNamesOfCars();

        List<Car> carList = CarFactory.generateCar(namesOfCars);
        cars = new Cars(carList);

        OutputView.printInputNumberOfMovesMessage();
        int numberOfMoves = Utils.convertStringToInt(InputView.inputNumberOfMoves());

        for (int i = 0; i < numberOfMoves; i++) {
            List<String> currentLocations = cars.moveCars(RandomNumberGenerator.generate());
            OutputView.printCurrentLocations(currentLocations);
        }

        String winnerNamesOfCars = cars.findWinnerCars();

        OutputView.printWinnerNames(winnerNamesOfCars);
    }
}
