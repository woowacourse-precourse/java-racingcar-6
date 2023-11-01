package racingcar.domain;

import java.util.List;

public class GameReferee {

    public GameResult totalGame(Cars cars) {
        int maxDistance = findMaxDistance(cars);
        return new GameResult(findWinners(cars, maxDistance));
    }

    private List<Car> findWinners(Cars cars, int maxDistance) {
        return cars.getCars().stream()
                .filter((car) -> isWinner(car, maxDistance))
                .toList();
    }

    private boolean isWinner(Car car, int maxDistance) {
        return car.getDistance() == maxDistance;
    }

    private int findMaxDistance(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }
}