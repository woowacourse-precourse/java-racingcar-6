package racingcar.domain.system.manager.position;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.domain.system.manager.car.SavedCar;
import racingcar.exceptions.runtime.NotFoundSourceException;

public class InMemoryCarPositionManager implements CarPositionManager {

    /**
     * Carkey를 기준으로 오름차순 정렬
     */
    private final Map<CarPositionKey, SavedCarPosition> positions = new TreeMap<>();

    public SavedCarPosition save(SavedCar car, Long position) {
        CarPositionKey key = CarPositionKey.of(car.getKey().getKey());
        positions.put(key, new SavedCarPosition(car, position, key));
        return positions.get(key);
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
