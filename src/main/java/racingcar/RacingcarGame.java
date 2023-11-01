package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {

    private List<Car> racingcars = new ArrayList<>();

    private void makeCars(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            racingcars.add(car);
        }
    }

    private void runRound(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            if (Random.isNumOverFour()) {
                car.moveForward();
            }
            int moveCount = car.getMoveCount();
            InputOutput.printRoundResult(name, moveCount);
        }
        System.out.println();
    }
}
