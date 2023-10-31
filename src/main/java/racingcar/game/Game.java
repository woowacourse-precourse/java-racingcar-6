package racingcar.game;

import static racingcar.car.CarMover.moveCarsIterator;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.io.InputHandler;
import racingcar.io.PrintHandler;

public class Game {
    public void start() {
        PrintHandler.inputCarNamesPrompt();
        List<String> carNamesWithoutSeparator = InputHandler.carNames();
        List<Car> cars = CarFactory.createCars(carNamesWithoutSeparator);

        PrintHandler.inputTrialNumberPrompt();
        int trialNum = InputHandler.tryNumber();

        PrintHandler.resultRunningSentence();
        moveCarsIterator(cars, trialNum);

        PrintHandler.finalWinnerSentence();
        List<String> winnerNames = findFinalWinner(cars);
        PrintHandler.finalWinner(winnerNames);
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
