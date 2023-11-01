package racingcar.model;

import java.util.List;

import static racingcar.constants.IntStore.STANDARD_NUMBER;

public class RunGame {

    private void moveOrStop(Car car) {
        int num = NumberGenerator.createRandomNumber();
        if (num >= STANDARD_NUMBER) {
            car.moveForward();
        }
    }
    public void iteration(List<Car> carList) {
        for (Car car : carList) {
            moveOrStop(car);
        }
    }
}
