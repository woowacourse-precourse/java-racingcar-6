package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.exception.car_racing_game.NotUniqueCarNameException;
import racingcar.exception.position.NotFoundPositionException;

public class CarRacingGame implements RacingGame {

    private final Map<Car, Position> racingTrack;

    public CarRacingGame(final Map<Car, Position> racingTrack) {
        validateDuplicateName(racingTrack);
        this.racingTrack = racingTrack;
    }

    private void validateDuplicateName(final Map<Car, Position> racingTrack) {
        int distinctCount = countDistinctElement(racingTrack);
        if (isDuplicate(distinctCount, racingTrack)) {
            List<String> keyList = convertKeySetToStringList(racingTrack);
            throw new NotUniqueCarNameException(keyList);
        }
    }

    private int countDistinctElement(final Map<Car, Position> racingTrack) {
        return (int) racingTrack.keySet().stream()
                .distinct()
                .count();
    }

    private boolean isDuplicate(final int distinctCount, final Map<Car, Position> racingTrack) {
        return distinctCount < racingTrack.size();
    }

    private List<String> convertKeySetToStringList(final Map<Car, Position> racingTrack) {
        return racingTrack.keySet().stream()
                .map(Car::getName)
                .toList();
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

    @Override
    public Map<Vehicle, Position> getRacingTrack() {
        return Collections.unmodifiableMap(racingTrack);
    }

    @Override
    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        return calculateWinners(maxPosition);
    }

    private int getMaxPosition() {
        return racingTrack.values().stream()
                .mapToInt(Position::getPositionIndex)
                .max()
                .orElseThrow(NotFoundPositionException::new);
    }

    private List<String> calculateWinners(int maxPosition) {
        return racingTrack.entrySet().stream()
                .filter(entry -> entry.getValue().getPositionIndex() == maxPosition)
                .map(entry -> entry.getKey().getName())
                .toList();
    }
}
