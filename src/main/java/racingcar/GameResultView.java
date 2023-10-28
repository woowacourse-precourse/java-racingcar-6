package racingcar;

import java.util.List;

public class GameResultView {

    public void printGameResult(List<Car> carNames) {
        for (Car car : carNames) {
            String movingDistance = "-".repeat(car.getMovingCount());
            System.out.println(car.getName() + " : " + movingDistance);
        }
        System.out.println();
    }
}
