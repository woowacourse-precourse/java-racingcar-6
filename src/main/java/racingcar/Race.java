package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    public void playRounds() {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.createRandomNumber();
            moveIfAble(car, randomNumber);
        }
    }

    private void moveIfAble(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.move();
        }
    }

    private void displayRoundResults() {
        // 각 라운드 결과를 출력
    }
}
