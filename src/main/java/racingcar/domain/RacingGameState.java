package racingcar.domain;

import java.util.List;

public class RacingGameState {
    private static final String GAME_NOT_ENDED_ERROR_MESSAGE = "게임이 끝나지 않아 우승자를 뽑을 수 없습니다.";

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
            throw new RuntimeException(GAME_NOT_ENDED_ERROR_MESSAGE);
        }
    }

    private int getMaxDistance() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }

    public List<String> getWinnersName() {
        validateIsGameEnd();
        int maxDistance = getMaxDistance();
        return cars.stream().filter(car -> car.isMaxDistance(maxDistance)).map(Car::getName).toList();
    }
}
