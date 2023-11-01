package racingcar;

import java.util.*;

public class Game {
    private final User user = new User();
    private int numberOfTurns;
    private List<Car> cars = new ArrayList<>();;

    public void start() {
        initializeGame();
        playGame();
        displayWinners();
    }

    private void initializeGame() {
        List<String> carNames = user.inputCarNames();
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        numberOfTurns = user.inputNumberOfTurns();
    }

    private void playGame() {
        // 각 턴 실행
    }

    private void displayWinners() {
        // 우승자를 계산하고 출력
    }
}
