package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.GameUI;
import racingcar.view.RaceView;

public class GameManager {
    private int remainingRounds;
    private List<Car> cars;

    public GameManager() {
    }

    public void runGame() {
        // 게임 전체적인 진행관리
    }

    private void setupGame() {
        List<String> carsName = GameUI.promptForCarNamesAndReturnList();
        for (String name : carsName) {
            this.cars.add(new Car(name));
        }
        this.remainingRounds = GameUI.promptForNumberOfRoundsAndReturnInteger();
    }

    private void playGame() {
        for (; this.remainingRounds > 0; this.remainingRounds--) {
            this.cars.forEach(Car::moveOnRandomCondition);
            RaceView.displayRoundResults(cars);
        }
    }

    private void displayGameResult() {
        List<Car> winner = determinWinner();
        RaceView.displayWinner(winner);
    }

    private List<Car> determinWinner() {
        int maxDistance = this.cars.stream().mapToInt(Car::getForwardDistance).max().getAsInt();
        return this.cars.stream().filter(car -> car.getForwardDistance() == maxDistance).toList();
    }
}
