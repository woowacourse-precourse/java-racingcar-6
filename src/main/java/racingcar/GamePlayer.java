package racingcar;

import java.util.List;

public class GamePlayer {
    private final List<Car> cars;
    private final int attempts;
    private final RandomNumber randomNumber;

    public GamePlayer(List<Car> cars, int attempts, RandomNumber randomNumber) {
        this.cars = cars;
        this.attempts = attempts;
        this.randomNumber = randomNumber;
    }
}
