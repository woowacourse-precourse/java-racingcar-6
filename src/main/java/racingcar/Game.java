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
        String inputCarName = user.inputCarName();
        String inputMoving = user.inputNumber();
        List<String> carNames = user.createCarNames(inputCarName);
        int movingNumber = user.createMovingNumber(inputMoving);
        car.move(carNames, movingNumber);
    }
}
