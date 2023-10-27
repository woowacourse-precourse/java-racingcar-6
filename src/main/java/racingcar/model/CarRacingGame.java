package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import racingcar.exception.position.NotExistPositionException;

public class CarRacingGame implements RacingGame {

    private final CarRacingManager carRacingManager;

    private CarRacingGame(final CarRacingManager carRacingManager) {
        this.carRacingManager = carRacingManager;
    }

    public static CarRacingGame createWith(final CarRacingManager carRacingManager) {
        return new CarRacingGame(carRacingManager);
    }

    @Override
    public void move() {
        carRacingManager.getCars().stream()
                .filter(Car::canMove)
                .forEach(this::moveNextPosition);
    }

    private void moveNextPosition(final Car car) {
        Position position = carRacingManager.getPosition(car);
        Position nextPosition = position.getNextPosition(position);
        carRacingManager.changePosition(car, nextPosition);
    }

    @Override
    public Map<Vehicle, Position> getVehiclePositionMap() {
        return Collections.unmodifiableMap(carRacingManager.getCarPositionMap());
    }

    @Override
    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        return calculateWinners(maxPosition);
    }

    private int getMaxPosition() {
        return carRacingManager.getPositions().stream()
                .mapToInt(Position::getPositionIndex)
                .max()
                .orElseThrow(NotExistPositionException::new);
    }

    private List<String> calculateWinners(final int maxPosition) {
        return carRacingManager.getCarPositionEntries().stream()
                .filter(entry -> entry.getValue().getPositionIndex() == maxPosition)
                .map(entry -> entry.getKey().getName())
                .toList();
    }
}
