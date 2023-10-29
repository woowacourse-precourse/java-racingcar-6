package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    private final List<String> carNames;
    private final List<List<Integer>> positionHistory;

    public RaceHistory(List<Car> cars) {
        carNames = cars.stream()
                .map(Car::getName)
                .toList();
        positionHistory = new ArrayList<>();
    }

    public void record(List<Car> cars) {
        List<Integer> positions = cars.stream()
                .map(Car::getPosition)
                .toList();
        positionHistory.add(positions);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<List<Integer>> getPositionHistory() {
        return positionHistory;
    }
}
