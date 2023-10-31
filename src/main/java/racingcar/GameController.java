package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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
        view.printExecutionTitle();
        for (int i = 0; i < roundCount; i++) {
            processRound();
            view.printExecutionResult(cars);
        }
    }

    private void processRound() {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                Car car = cars.get(i);
                car.increaseStep();
            }
        }
    }

    private void endGame() {
    }
}
