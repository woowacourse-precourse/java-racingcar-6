package racingcar;

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
        }
    }
    public String getWinner() {
        return null;
    }
    private int getMaximumPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }


}
