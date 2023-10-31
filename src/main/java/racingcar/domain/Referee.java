package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import racingcar.domain.dto.CarStatus;
import racingcar.domain.dto.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private static final int PROCEED_CONDITION = 4;
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void addCar(String name) {
        cars.add(new Car(name));
    }

    public void startTurn() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.getRandomNumber();
            if (isProceedNumber(randomNumber)) {
                car.proceed();
            }
        }
    }

    private static boolean isProceedNumber(int randomNumber) {
        return randomNumber >= PROCEED_CONDITION;
    }

    public GameStatus getGameStatus() {
        GameStatus gameStatus = new GameStatus();
        for (Car car : cars) {
            gameStatus.addCarStatus(CarStatus.of(car));
        }
        return gameStatus;
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
}
