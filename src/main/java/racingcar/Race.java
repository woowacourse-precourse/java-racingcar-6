package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void playRounds() {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.createRandomNumber();
            moveIfAble(car, randomNumber);
        }
        displayRoundResults();
    }

    private void moveIfAble(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.move();
        }
    }

    private void displayRoundResults() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
