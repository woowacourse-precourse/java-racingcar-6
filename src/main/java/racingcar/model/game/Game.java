package racingcar.model.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.dto.GameResult;
import racingcar.util.CarNameValidator;

public class Game {
    private final GameTime gameTime;
    private final Cars cars;

    public Game(final int gameTime, final List<String> carNames) {
        this.gameTime = new GameTime(gameTime);
        this.cars = new Cars(makeCars(carNames));
    }

    private List<Car> makeCars(final List<String> carName) {
        CarNameValidator.validateUniqueNameCheck(carName);
        return carName
                .stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isGameNotEnded() {
        return gameTime.isGameNotEnded();
    }

    public void playGame() {
        cars.playRound();
        gameTime.plusGameTime();
    }

    public List<String> getWinnerCars() {
        return cars.getWinnerCars();
    }

    public List<GameResult> generateGameResultList() {
        return cars.generateGameResultList();
    }
}
