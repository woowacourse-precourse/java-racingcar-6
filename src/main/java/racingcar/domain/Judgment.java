package racingcar.domain;

import java.util.List;

public class Judgment {
    public void decideMovement(List<Car> carList) {
        final RandomGenerator randomGenerator = new RandomGenerator();
        for (Car car : carList) {
            int value = randomGenerator.createRandomNumber();
            if (value > 3 && value < 10) {
                car.goForward();
            }
            else {
                // 정지
            }
        }
    }
}
