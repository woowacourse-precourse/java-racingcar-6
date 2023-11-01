package racingcar.game;

import java.util.List;
import racingcar.car.Car;
import racingcar.race.Race;
import racingcar.utils.OutputUtil;

public class Game {
    private final Race race;
    private final int attemptNumber;

    public Game(List<Car> cars, int attemptNumber) {
        this.race = new Race(cars);
        this.attemptNumber = attemptNumber;
    }

    public void start() {
        for (int i = 0; i < attemptNumber; i++) {
            race.run();
            printCarStatus();
        }
    }

    private void printCarStatus() {
        for (Car car: race.getCars()) {
            OutputUtil.printStatus(car);
        }
    }
}
