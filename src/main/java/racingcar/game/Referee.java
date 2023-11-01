package racingcar.game;

import racingcar.car.Car;
import racingcar.numberGenerator.NumberGenerator;
import racingcar.user.UserInput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    UserInput user = new UserInput();
    Map<String, String> raceScore = new HashMap<>();

    NumberGenerator numberGenerator = new NumberGenerator();

    public int userAttemptCount() {
      return user.attemptCountInput();
    }

    public Boolean isMovingCondition() {
        int randomNumber = numberGenerator.createRandomNumber();
        return randomNumber >= 4;
    }

    public void runRace(List<Car> cars, int tryCount) {
        for (Car car : cars) {
            System.out.println("Car names: " + car.getCarName());
            System.out.println("Is moving: " + car.isMoveForward());
            System.out.println();
        }
    }

}
