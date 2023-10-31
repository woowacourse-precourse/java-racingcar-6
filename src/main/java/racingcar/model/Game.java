package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.GameResult;
import racingcar.util.CarNameValidator;

public class Game {
    private final GameTime gameTime;
    private final Cars cars;

    public Game(int gameTime, List<String> carNames) {
        this.gameTime = new GameTime(gameTime);
        this.cars = new Cars(makeCars(carNames));
    }

    private List<Car> makeCars(List<String> carName) {
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
