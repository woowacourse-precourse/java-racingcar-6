package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.GameUI;
import racingcar.view.RaceView;

public class GameManager {
    private int remainingRounds;
    private List<Car> cars;
    private NumberGenerator numberGenerator;

    public GameManager() {
    }

    public void runGame() {
        cars = new ArrayList<>();
        numberGenerator = new RandomNumberGenerator();
        setupGame();
        playGame();
        displayGameResult();
    }

    private void setupGame() {
        List<String> carsName = GameUI.promptForCarNames();
        for (String name : carsName) {
            cars.add(new Car(name));
        }
        remainingRounds = GameUI.promptForNumberOfRounds();
    }

    private void playGame() {
        for (; remainingRounds > 0; remainingRounds--) {
            cars.forEach(car -> car.move(numberGenerator));
            RaceView.displayRoundResults(cars);
        }
    }

    private void displayGameResult() {
        List<Car> winners = determineWinners();
        RaceView.displayWinner(winners);
    }

    private List<Car> determineWinners() {
        int maxDistance = this.cars.stream()
                .mapToInt(Car::getForwardDistance)
                .max()
                .orElse(0);

        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getForwardDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}
