package racingcar.model;

import java.util.List;
import racingcar.util.MoveResolver;

public class Game {
    private final int MOVING_DISTANCE = 1;
    private final MoveResolver moveResolver = new MoveResolver();
    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(MOVING_DISTANCE,moveResolver);
        }
    }

    public void getWinners() {

    }
}
