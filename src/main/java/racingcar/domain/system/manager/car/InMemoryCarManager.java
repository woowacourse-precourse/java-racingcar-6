package racingcar.domain.system.manager.car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.exceptions.runtime.DuplicatedCarNameException;
import racingcar.exceptions.runtime.NotFoundSourceException;

public class InMemoryCarManager implements CarManager {

    /**
     * Carkey를 기준으로 오름차순 정렬
     */
    private final Map<CarKey, SavedCar> cars = new TreeMap<>();


    @Override
    public SavedCar save(Car car) {
        validate(car);
        CarKey key = CarKey.of(car.getCarName());
        SavedCar savedCar = new SavedCar(car, key);
        cars.put(key, savedCar);
        return savedCar;
    }

    private void validate(Car car) {
        Collection<SavedCar> innerSources = cars.values();
        validateDuplicateCar(innerSources, car);
    }

    private void validateDuplicateCar(Collection<SavedCar> innerSources, Car car) {
        innerSources.stream().filter(source -> source.getCarName().equals(car.getCarName()))
            .findAny()
            .ifPresent(c -> {
                throw new DuplicatedCarNameException();
            });
    }

    @Override
    public List<SavedCar> saveAll(List<Car> cars) {
        return cars.stream().map(this::save).sorted(Comparator.comparing(SavedCar::getKey))
            .collect(Collectors.toList());
    }

    @Override
    public SavedCar findByName(CarName carName) {
        return cars.values().stream().filter(carNameFilter(carName)).findAny()
            .orElseThrow(NotFoundSourceException::new);
    }

    private Predicate<SavedCar> carNameFilter(CarName carName) {
        return car -> car.getCarName().equals(carName);
    }

    @Override
    public List<SavedCar> findAll() {
        return cars.values().stream().toList();
    }

    @Override
    public List<SavedCar> findAll(List<CarKey> keys) {
        List<SavedCar> savedCars = new ArrayList<>();
        for (CarKey key : keys) {
            SavedCar car = cars.get(key);
            savedCars.add(car);
        }
        return savedCars;
    }
}
