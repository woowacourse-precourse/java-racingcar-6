package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.GameUI;
import racingcar.view.RaceView;

public class GameManager {
    private int remainingRounds;
    private final List<Car> cars;

    public GameManager() {
        this.cars = new ArrayList<>();
    }

    public void runGame() {
        setupGame();
        playGame();
        displayGameResult();
    }

    private void setupGame() {
        List<String> carsName = GameUI.getCarNamesWithPrompt();
        for (String name : carsName) {
            this.cars.add(new Car(name));
        }
        this.remainingRounds = GameUI.getRoundsWithPrompt();
    }

    private void playGame() {
        for (; this.remainingRounds > 0; this.remainingRounds--) {
            this.cars.forEach(Car::moveOnRandomCondition);
            RaceView.displayRoundResults(cars);
        }
    }

    private void displayGameResult() {
        List<Car> winner = determineWinner();
        RaceView.displayWinner(winner);
    }

    private List<Car> determineWinner() {
        int maxDistance = this.cars.stream()
                .mapToInt(Car::getForwardDistance)
                .max().orElse(0);
        return this.cars.stream()
                .filter(car -> car.getForwardDistance() == maxDistance)
                .toList();
    }
}
