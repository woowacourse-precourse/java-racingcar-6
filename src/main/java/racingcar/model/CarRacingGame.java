package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import racingcar.exception.car_racing_game.NotUniqueCarNameException;
import racingcar.exception.position.NotExistPositionException;

public class CarRacingGame implements RacingGame {

    private final Map<Car, Position> carPositionMap;

    public CarRacingGame(final Map<Car, Position> carPositionMap) {
        validateDuplicateName(carPositionMap);
        this.carPositionMap = carPositionMap;
    }

    private void validateDuplicateName(final Map<Car, Position> carPositionMap) {
        int distinctCount = countDistinctElement(carPositionMap);
        if (isDuplicate(distinctCount, carPositionMap)) {
            List<String> keyList = convertKeySetToStringList(carPositionMap);
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
        carPositionMap.keySet().stream()
                .filter(Car::canMove)
                .forEach(this::moveNextPosition);
    }

    private void moveNextPosition(final Car car) {
        Position position = carPositionMap.get(car);
        Position nextPosition = position.getNextPosition(position);
        carPositionMap.put(car, nextPosition);
    }

    @Override
    public Map<Vehicle, Position> getVehiclePositionMap() {
        return Collections.unmodifiableMap(carPositionMap);
    }

    @Override
    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        return calculateWinners(maxPosition);
    }

    private int getMaxPosition() {
        return carPositionMap.values().stream()
                .mapToInt(Position::getPositionIndex)
                .max()
                .orElseThrow(NotExistPositionException::new);
    }

    private List<String> calculateWinners(int maxPosition) {
        return carPositionMap.entrySet().stream()
                .filter(entry -> entry.getValue().getPositionIndex() == maxPosition)
                .map(entry -> entry.getKey().getName())
                .toList();
    }
}
