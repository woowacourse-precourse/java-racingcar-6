package racingcar.core;

import racingcar.domain.Car;

import java.util.List;

public class GameProgressSystem {
    private final Output output;

    public GameProgressSystem(final Output output) {
        this.output = output;
    }

    public void progress(List<Car> cars){
        for (Car car : cars) {
            car.tryMove();
        }
        output.printResult(cars);
    }
}
