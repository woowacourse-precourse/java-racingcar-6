package racingcar.domain.system.manager.position;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import racingcar.domain.core.car.CarName;
import racingcar.domain.system.manager.car.SavedCar;
import racingcar.exceptions.runtime.NotFoundSourceException;

public class InMemoryCarPositionManager implements CarPositionManager {

    private static final Comparator<? super CarName> keyComparator =
        Comparator.comparing(CarName::getName);
    private final Map<CarName, SavedCarPosition> positions = new TreeMap<>(keyComparator);

    public SavedCarPosition save(SavedCar car, Long position) {
        positions.put(car.getKey(), new SavedCarPosition(car, position));
        return positions.get(car.getKey());
    }

    public List<SavedCarPosition> saveAll(Map<SavedCar, Long> carPositions) {
        Set<Entry<SavedCar, Long>> sources = carPositions.entrySet();
        return sources.stream()
            .map(source -> save(source.getKey(), source.getValue()))
            .collect(Collectors.toList());
    }

    public SavedCarPosition findByCar(SavedCar car) {
        SavedCarPosition position = positions.get(car.getKey());
        if (Objects.isNull(position)) {
            throw new NotFoundSourceException();
        }
        return position;
    }

    public Map<CarName, SavedCarPosition> findAll(List<SavedCar> cars) {
        Map<CarName, SavedCarPosition> results = new TreeMap<>(keyComparator);
        for (SavedCar car : cars) {
            results.put(car.getKey(), findByCar(car));
        }
        return results;
    }
}
