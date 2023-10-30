package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.GameResult;

public class Game {
    private final int gameTime;
    private final Cars cars;
    private int currentGameTime = 0;

    public Game(int gameTime, List<String> carNames) {
        this.gameTime = gameTime;
        this.cars = new Cars(makeCars(carNames));
    }

    private List<Car> makeCars(List<String> carName) {
        return carName
                .stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isGameNotEnded() {
        return currentGameTime != gameTime;
    }

    public void playGame() {
        cars.playRound();
        currentGameTime += 1;
    }

    public List<String> getWinnerCars() {
        return cars.getWinnerCars();
    }

    public List<GameResult> generateGameResultList() {
        return cars.generateGameResultList();
    }
}
