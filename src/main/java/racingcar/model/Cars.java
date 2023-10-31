package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validCarNames(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validCarNames(List<Car> cars) {
        Set<String> nameSet = new HashSet<>();
        checkDuplicateCarName(cars, nameSet);
    }

    private void checkDuplicateCarName(List<Car> cars, Set<String> nameSet) {
        for (Car car : cars) {
            CarName carName = car.getName();
            String name = carName.getRawName();
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException();
            }
            nameSet.add(name);
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
