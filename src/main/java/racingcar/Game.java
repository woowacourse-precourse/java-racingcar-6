package racingcar;

import java.util.List;

public class Game {

    private final Cars cars;

    public Game(String carNames) {
        cars = new Cars(carNames);
    }

    public Cars getCars() {
        return cars;
    }

    public void playRound() {
        for (Car car : cars.toList()) {
            car.moveForward();
        }
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
