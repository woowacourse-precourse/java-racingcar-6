package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceStatus {
    private final List<Car> raceStatus;

    public RaceStatus(List<Car> raceStatus) {
        this.raceStatus = raceStatus;
    }

    public List<Car> getWinner() {
        int maxPosition = raceStatus.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get().getPosition();

        return raceStatus.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    public List<Car> getCurrentStatus() {
        return raceStatus;
    }
}
