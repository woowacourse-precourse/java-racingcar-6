package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.InputUtils;
import racingcar.utils.RandomUtils;
import racingcar.view.GameView;

public class RacingCarGame {
    private final GameView gameView;
    private List<Car> cars;
    private int round;

    public RacingCarGame() {
        this.gameView = new GameView();
    }

    public void play() {
        inputCarNames();
        inputRound();
        race();
        displayResults();
    }

    private void inputCarNames() {
        gameView.promptForCarNames();
        cars = InputUtils.promptForCar();
    }

    private void inputRound() {
        gameView.promptForRoundCount();
        round = InputUtils.promptForInt();
        System.out.println();
    }

    private void race() {
        gameView.displayExecutionResults();
        for (int i = 0; i < round; i++) {
            raceOneRound();
            gameView.displayRoundResults(cars);
            System.out.println();
        }
    }

    private void raceOneRound() {
        for (Car car : cars) {
            int randomNumber = RandomUtils.generateRandomNumber();
            if (randomNumber >= 4) {
                car.advancePosition();
            }
        }
    }

    private void displayResults() {
        gameView.displayWinners(findWinners());
    }

    private List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return findWinningCarNames(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> findWinningCarNames(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .toList();
    }
}
