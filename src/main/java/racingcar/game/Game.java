package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.car.CarMover;
import racingcar.io.InputHandler;
import racingcar.io.PrintHandler;
import racingcar.util.RandomManipulator;

public class Game {
    public void start() {
        PrintHandler.inputCarNamesPrompt();
        List<String> carNames = InputHandler.carNames();
        List<Car> cars = CarFactory.createCars(carNames);

        PrintHandler.inputTrialNumberPrompt();
        int trialNum = InputHandler.tryNumber();

        PrintHandler.resultRunningSentence();
        moveCarsIterator(cars, trialNum);

        PrintHandler.finalWinnerSentence();
        List<String> winnerNames = findFinalWinner(cars);
        PrintHandler.finalWinner(winnerNames);
    }

    private void moveCarsIterator(List<Car> cars, int trialNum) {
        final RandomManipulator randomManipulator = new RandomManipulator();
        final CarMover carMover = new CarMover(randomManipulator);

        for (int i = 0; i < trialNum; i++) {
            carMover.moveCars(cars);
            PrintHandler.resultRunning(cars);
        }
    }

    private List<String> findFinalWinner(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        int maxLocation = findMaxLocation(cars);

        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winnerNames.add(car.getName());
            }
        }

        return winnerNames;
    }

    private int findMaxLocation(List<Car> cars) {
        int maxLocation = cars.get(0).getLocation();

        for (Car car : cars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }
        }

        return maxLocation;
    }
}
