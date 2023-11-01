package racingcar.model;

import java.util.List;
import racingcar.model.strategy.MoveStrategy;

public class GameFactory {
    public static Game createGame(List<String> carNames, int totalRounds, MoveStrategy moveStrategy) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, moveStrategy))
                .toList();
        return new Game(cars, totalRounds);
    }
}
