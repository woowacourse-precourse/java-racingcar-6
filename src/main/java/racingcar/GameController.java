package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    int RANDOM_MIN = 0;
    int RANDOM_MAX = 9;
    int THRESHOLD = 4;
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
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (randomNumber >= THRESHOLD) {
                Car car = cars.get(i);
                car.increaseStep();
            }
        }
    }

    private void endGame() {
        Collections.sort(cars);
        int maxStep = cars.get(0).getStep();
        List<String> winners = new ArrayList<>();
        for (Car car: cars) {
            if (car.getStep() == maxStep) winners.add(car.getName());
        }
        view.printWinners(winners);
    }
}
