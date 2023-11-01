package racingcar.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.Game;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        List<String> carNames = inputCarNames();
        int tryNumber = getTryNumber();

        Cars cars = new Cars(carNames);
        Game game = new Game(tryNumber);

        OutputView.informPlayResult();
        performRound(cars, game);
        sortFinalWinner(cars);
    }

    private List<String> inputCarNames() {
        String carNames = InputView.askCarNames();
        List<String> carName = splitCarNames(carNames);
        InputValidator.validateCarNameLength(carName);
        return carName;
    }

    private int getTryNumber() {
        String stringNumber = InputView.askTryNumber();
        InputValidator.validateTryNumberType(stringNumber);
        return Integer.parseInt(stringNumber);
    }

    private void performRound(Cars cars, Game game) {
        for (int i = 0; i < game.getTryNumber(); i++) {
            cars.moveCars();
            OutputView.informCarMoveDistance(cars.getCars());
        }
    }

    private void sortFinalWinner(Cars cars) {
        List<Car> sortedCars = getSortedCars(cars.getCars());
        List<Car> farthestCars = getFarthestCars(sortedCars);
        List<String> winnerCarNames = getWinnerCarNames(farthestCars);
        OutputView.informFinalWinner(winnerCarNames);
    }

    private List<Car> getSortedCars(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getCarLocation).reversed()).toList();
    }

    private List<Car> getFarthestCars(List<Car> sortedCars) {
        int farthestLocation = sortedCars.get(0).getCarLocation();
        return sortedCars.stream()
                .filter(car -> car.getCarLocation() == farthestLocation).toList();
    }

    private List<String> getWinnerCarNames(List<Car> farthestCars) {
        return farthestCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }
}