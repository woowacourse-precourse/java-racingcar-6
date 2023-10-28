package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.InputUtils;
import racingcar.utils.RandomUtils;
import racingcar.view.GameView;

public class RaceGame {
    private final GameView gameView;
    private List<Car> cars;
    private int round;

    public RaceGame() {
        this.gameView = new GameView();
    }

    public void play() {
        gameView.displayUserInputCarNamePrompt();
        cars = InputUtils.promptForCar();

        gameView.displayUserInputRoundPrompt();
        round = InputUtils.promptForString();

        System.out.println();

        gameView.displayResultMessage();
        for (int i = 0; i < round; i++) {
            raceOneRound();
            gameView.displayOneRoundResultMessage(cars);
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
}
