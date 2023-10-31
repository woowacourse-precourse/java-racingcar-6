package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;

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
