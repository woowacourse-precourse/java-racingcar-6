package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.NumberGenerator;
import racingcar.view.GameUI;
import racingcar.view.RaceView;

public class GameManager {
    private int remainingRounds;
    private List<Car> cars;
    private final NumberGenerator numberGenerator;

    public GameManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void runGame() {
        cars = new ArrayList<>();
        setupGame();
        playGame();
        displayGameResult();
    }

    private void setupGame() {
        List<String> carsNames = GameUI.promptForCarNames();
        for (String name : carsNames) {
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
        List<Car> winners = GameResultAnalyzer.determineWinners(cars);
        RaceView.displayWinner(winners);
    }
}
