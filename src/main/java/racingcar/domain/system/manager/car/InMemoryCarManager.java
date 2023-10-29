package racingcar.domain.system.manager.car;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import racingcar.domain.core.car.Car;
import racingcar.domain.core.car.CarName;
import racingcar.exceptions.runtime.DuplicatedCarNameException;
import racingcar.exceptions.runtime.NotFoundSourceException;

public class InMemoryCarManager implements CarManager {

    private static final Comparator<? super CarName> keyComparator =
        Comparator.comparing(CarName::getName);
    private final Map<CarName, Car> cars = new TreeMap<>(keyComparator);


    public SavedCar save(Car car) {
        validate(car);
        cars.put(car.getCarName(), car);
        return new SavedCar(car);
    }

    private void validate(Car car) {
        Collection<Car> sources = cars.values();
        validateDuplicateCar(sources, car);
    }

    private void validateDuplicateCar(Collection<Car> sources, Car car) {
        sources.stream()
            .filter(source -> source.getName().equals(car.getName()))
            .findAny()
            .ifPresent(c -> {
                throw new DuplicatedCarNameException();
            });
    }

    public List<SavedCar> saveAll(List<Car> cars) {
        return cars.stream().map(this::save).toList();
    }

    public SavedCar findByName(CarName carName) {
        Car car = cars.get(carName);
        if (Objects.isNull(car)) {
            throw new NotFoundSourceException();
        }
        return new SavedCar(car);
    }

    public List<SavedCar> findAll() {
        return List.copyOf(cars.values().stream().map(SavedCar::new).toList());
    }
}
