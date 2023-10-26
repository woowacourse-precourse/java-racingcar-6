package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.car_racing_game.NotUniqueCarNameException;

public class CarRacingGame implements RacingGame {
    private final Map<Car, Position> racingTrack;

    public CarRacingGame(final Map<Car, Position> racingTrack) {
        validate();
        this.racingTrack = racingTrack;
    }

    private void validate() {
        int distinctCount = countDistinctElement();
        if (isDuplicate(distinctCount)) {
            List<String> keyList = convertKeySetToStringList();
            throw new NotUniqueCarNameException(keyList);
        }
    }

    private int countDistinctElement() {
        return (int) racingTrack.keySet().stream()
                .distinct()
                .count();
    }

    private boolean isDuplicate(final int distinctCount) {
        return distinctCount < racingTrack.size();
    }

    private List<String> convertKeySetToStringList() {
        return racingTrack.keySet().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public void move() {
        Set<Car> cars = racingTrack.keySet();
        cars.stream()
                .filter(Car::canMove)
                .forEach(this::moveNextPosition);
    }

    private void moveNextPosition(final Car car) {
        Position position = racingTrack.get(car);
        Position nextPosition = position.getNextPosition(position);
        racingTrack.put(car, nextPosition);
    }
}
