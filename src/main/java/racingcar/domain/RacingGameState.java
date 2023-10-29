package racingcar.domain;

import java.util.List;
import racingcar.constant.IllegalStateExceptionType;

public class RacingGameState {
    private static final int MIN_DISTANCE = 0;

    private final boolean isGameEnd;
    private final List<Car> cars;

    public RacingGameState(boolean isGameEnd, List<Car> cars) {
        this.isGameEnd = isGameEnd;
        this.cars = cars;
    }

    public int getCarAmount() { return cars.size(); }

    public String getCarNameByIndex(int i) {
        Car car = cars.get(i);

        return car.getName();
    }

    public int getCarDistanceByIndex(int i) {
        Car car = cars.get(i);

        return car.getDistance();
    }

    private void validateIsGameEnd() {
        if (!isGameEnd) {
            throw IllegalStateExceptionType.GAME_NOT_ENDED_MESSAGE.getException();
        }
    }

    private int getMaxDistance() {
        int max = MIN_DISTANCE;
        for (Car car : cars) {
            max = Math.max(max, car.getDistance());
        }

        return max;
    }

    public List<String> getWinnersName() {
        validateIsGameEnd();
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.isMaxDistance(maxDistance))
                .map(Car::getName)
                .toList();
    }
}
