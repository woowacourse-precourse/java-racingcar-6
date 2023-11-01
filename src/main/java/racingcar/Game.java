package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars;
    private int round;

    public Game(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }
    public void play() {
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.move();
            }
            displayResult();
        }
    }
    // getMaximumPosition()을 이용해서 우승자 찾기
    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaximumPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
    private int getMaximumPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
    private void displayResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
