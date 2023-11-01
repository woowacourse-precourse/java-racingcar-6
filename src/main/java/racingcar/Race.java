package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    public void playRounds(int turn) {
        for (Car car : cars) {
            //각 car에 전진여부

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
