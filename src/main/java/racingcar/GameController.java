package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    GameView view = new GameView();
    int roundCount;
    List<Car> cars;

    public void startGame() {
        setupGame();
        processRounds();
        endGame();
    }

    private void setupGame() {
        List<String> carNames = view.getCarNames();
        cars = new ArrayList<>();
        for (String carName: carNames) {
            cars.add(new Car(carName));
        }
        roundCount = view.getRoundCount();
    }

    private void processRounds() {
    }

    private void processRound() {
    }

    private void endGame() {
    }
}
