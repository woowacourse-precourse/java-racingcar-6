package racingcar.domain;

import java.util.List;

public class GameResult {
    public GameResult() {
    }
    public void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getLocation());
        }
        System.out.println();
    }
}
