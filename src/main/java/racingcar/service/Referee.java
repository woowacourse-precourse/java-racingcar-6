package racingcar.service;

import racingcar.models.Car;
import racingcar.models.CarStatus;
import racingcar.models.GameStatus;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private static final int PROCEED_CONDITION = 4;

    private final List<Car> cars = new ArrayList<>();
    private final List<GameStatus> gameStatuses = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void addCars(List<String> carNames) {
        carNames.stream().map(Car::new).forEach(cars::add);
    }

    public void startGame(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            startTurn();
            saveGameStatus();
        }
    }

    private void startTurn() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.getRandomNumber();
            if (isProceedNumber(randomNumber)) {
                car.proceed();
            }
        }
    }

    private boolean isProceedNumber(int randomNumber) {
        return randomNumber >= PROCEED_CONDITION;
    }

    private void saveGameStatus() {
        GameStatus gameStatus = new GameStatus();
        cars.stream().map(CarStatus::of).forEach(gameStatus::addCarStatus);
        gameStatuses.add(gameStatus);
    }

    public List<String> getWinners() {
        int distanceOfWinner = getDistanceOfWinner();
        return cars.stream()
                .filter(car -> car.isWinner(distanceOfWinner))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getDistanceOfWinner() {
        return cars.stream().mapToInt(Car::getMoveDistance).max().orElseThrow();
    }

    public List<GameStatus> getGameStatuses() {
        return gameStatuses;
    }

    public List<Car> getCars() {
        return cars;
    }
}
