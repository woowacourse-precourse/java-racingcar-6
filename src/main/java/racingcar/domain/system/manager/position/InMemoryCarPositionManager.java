package racingcar.domain.system.manager.position;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import racingcar.domain.system.manager.car.value.SavedCar;
import racingcar.domain.system.manager.position.key.CarPositionKey;
import racingcar.domain.system.manager.position.value.SavedCarPosition;
import racingcar.exceptions.runtime.NotFoundSourceException;

public class InMemoryCarPositionManager implements CarPositionManager {

    /**
     * Carkey를 기준으로 오름차순 정렬
     */
    private final Map<CarPositionKey, SavedCarPosition> positions = new TreeMap<>();

    /**
     * save로 save와 update를 동시에 사용하고 있음
     */
    public SavedCarPosition save(SavedCar car, Long position) {
        if (isUpdate(car)) {
            CarPositionKey key = getKey(car);
            return getSavedCarPosition(key, car, position);
        }
        CarPositionKey key = getKey();
        return getSavedCarPosition(key, car, position);
    }

    private boolean isUpdate(SavedCar car) {
        return positions.values().stream().anyMatch(position -> position.getSavedCar().equals(car));
    }

    private SavedCarPosition getSavedCarPosition(CarPositionKey key, SavedCar car, Long position) {
        positions.put(key, new SavedCarPosition(car, position, key));
        return positions.get(key);
    }

    /**
     * isUpdate로 이미 존재 확인된 상태이기에 바로 Optional.get() 사용
     */
    private CarPositionKey getKey(SavedCar car) {
        return positions.entrySet().stream().filter(getMatchCar(car)).findFirst().get().getKey();
    }

    private CarPositionKey getKey() {
        int currentIdx = positions.size();
        return CarPositionKey.of(currentIdx + 1L);
    }

    private Predicate<Entry<CarPositionKey, SavedCarPosition>> getMatchCar(SavedCar car) {
        return e -> {
            SavedCarPosition position = e.getValue();
            return position.getSavedCar().equals(car);
        };
    }

    public List<SavedCarPosition> saveAll(Map<SavedCar, Long> carPositions) {
        Set<Entry<SavedCar, Long>> sources = carPositions.entrySet();
        return sources.stream().map(saveFunction())
            .sorted(Comparator.comparing(SavedCarPosition::getKey)).collect(Collectors.toList());
    }

    private Function<Entry<SavedCar, Long>, SavedCarPosition> saveFunction() {
        return source -> {
            SavedCar car = source.getKey();
            Long position = source.getValue();
            return save(car, position);
        };
    }

    public SavedCarPosition findByCar(SavedCar car) {
        return positions.values().stream().filter(position -> position.getSavedCar().equals(car))
            .findAny().orElseThrow(NotFoundSourceException::new);
    }

    public List<SavedCarPosition> findAll(List<SavedCar> cars) {
        List<SavedCarPosition> results = new ArrayList<>();
        for (SavedCar car : cars) {
            results.add(findByCar(car));
        }
        return results;
    }
}
