package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.GameResult;

public class GameService {
    private final Game game = new Game();

    public void enrollCars(List<String> carNames) {
        carNames.forEach(this::enrollCar);
    }

    private void enrollCar(String carName) {
        Car car = new Car(carName);
        game.addCar(car);
    }

    public List<GameResult> runGame() {
        game.playRound();
        return game.generateGameResultList();
    }
}
