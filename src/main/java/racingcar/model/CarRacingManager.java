package racingcar.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import racingcar.exception.car_racing_game.NotUniqueCarNameException;

public class CarRacingManager {

    private final Map<Car, Position> carPositionMap;

    public CarRacingManager(final Map<Car, Position> carPositionMap) {
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

    private int countDistinctElement(final Map<Car, Position> carPositionMap) {
        return (int) carPositionMap.keySet().stream()
                .distinct()
                .count();
    }

    private boolean isDuplicate(final int distinctCount, final Map<Car, Position> carPositionMap) {
        return distinctCount < carPositionMap.size();
    }

    private List<String> convertKeySetToStringList(final Map<Car, Position> carPositionMap) {
        return carPositionMap.keySet().stream()
                .map(Car::getName)
                .toList();
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(carPositionMap.keySet());
    }

    public Collection<Position> getPositions() {
        return Collections.unmodifiableCollection(carPositionMap.values());
    }

    public Position getPosition(final Car car) {
        return carPositionMap.get(car);
    }

    public void changePosition(final Car car, final Position newPosition) {
        carPositionMap.put(car, newPosition);
    }

    public Map<Car, Position> getCarPositionMap() {
        return Collections.unmodifiableMap(carPositionMap);
    }

    public Set<Entry<Car, Position>> getCarPositionEntries() {
        return Collections.unmodifiableSet(carPositionMap.entrySet());
    }
}
