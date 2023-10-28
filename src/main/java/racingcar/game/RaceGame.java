package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.InputUtils;
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
    }
}
