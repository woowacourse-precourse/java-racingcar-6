package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.view.GameView;

public class GameRoundManager {
    private final List<Car> cars;
    private final GameView gameView;

    public GameRoundManager(List<Car> cars, GameView gameView) {
        this.cars = cars;
        this.gameView = gameView;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
        gameView.printRoundResult(cars);
    }
}