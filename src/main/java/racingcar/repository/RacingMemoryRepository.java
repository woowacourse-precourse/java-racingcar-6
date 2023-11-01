package racingcar.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingMemoryRepository implements RacingRepository {
    private RacingMemoryRepository instance = new RacingMemoryRepository();

    public static RacingMemoryRepository getInstance() {
        return instance;
    }

    private final Map<Integer, List<Car>> raceResults = new HashMap<>();
    private final Map<String, Car> cars = new HashMap<>();
    private int raceCount = 0;

    @Override
    public void saveRaceResult(List<Car> cars) {
        raceResults.put(raceCount++, cars);
    }

    @Override
    public List<List<Car>> getRaceResults() {
        return raceResults.values().stream().toList();
    }

    @Override
    public void create(Car car) {
        cars.put(car.getName(), car);
    }

    @Override
    public List<Car> findAll() {
        return cars.values().stream().toList();
    }

    @Override
    public List<Car> getWinners() {
        List<Car> cars = raceResults.get(raceCount - 1);

        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        int finalMaxPosition = maxPosition;

        return cars.stream()
                .filter(car -> car.getPosition() == finalMaxPosition)
                .toList();
    }
}
