package racingcar;

import java.util.List;

public class Game {
    private User user;
    private Car car;

    public Game() {
        user = new User();
        car = new Car();
    }

    public void start() {
        List<String> carNames = user.createCarNames(user.input());
        int movingNumber = user.createMovingNumber(user.input());
        car.move(carNames, movingNumber);
    }
}
