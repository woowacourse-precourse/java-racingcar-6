package racingcar.game;

import racingcar.car.Car;
import racingcar.numberGenerator.NumberGenerator;
import racingcar.user.UserInput;

import java.util.HashMap;
import java.util.Map;

public class Referee {
    UserInput user = new UserInput();
    Map<String, String> raceScore = new HashMap<>();
    public Boolean isMoving = isMovingCondition();

    NumberGenerator numberGenerator = new NumberGenerator();

    private int userAttemptCount() {
      return user.attemptCountInput();
    }

    private Boolean isMovingCondition() {
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= 4;
    }

    public void runRace(Car car, int tryCount) {

    }

}
