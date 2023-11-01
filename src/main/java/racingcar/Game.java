package racingcar;

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
        String inputCarName = user.inputCarName();
        String inputMoving = user.inputNumber();
        List<String> carNames = user.createCarNames(inputCarName);
        int movingNumber = user.createMovingNumber(inputMoving);
        Map<String, Integer> carNameAndMoving = car.setForRacing(carNames);
        Map<String, Integer> racingResult = car.runRacing(carNameAndMoving, movingNumber);
        Result result = new Result();
        result.printRacingWinner(racingResult);
    }
}
