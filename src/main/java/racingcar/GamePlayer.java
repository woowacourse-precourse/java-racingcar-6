package racingcar;

import java.util.List;

public class GamePlayer {
    private final List<Car> cars;
    private final int attempts;
    private final RandomNumber randomNumber;

    public GamePlayer(List<Car> cars, int attempts, RandomNumber randomNumber) {
        this.cars = cars;
        this.attempts = attempts;
        this.randomNumber = randomNumber;
    }

    public void play() {
        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < cars.size(); j++) {
                int number = randomNumber.generate();
                cars.get(j).move(randomNumber.judge(number));
                OutputView.printResult(cars.get(j), cars.get(j).getDistance());
            }
        }
    }
}
