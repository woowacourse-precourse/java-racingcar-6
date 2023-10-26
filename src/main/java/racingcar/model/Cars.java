package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        List<String> nameList = new ArrayList<>();
        cars.forEach(car -> nameList.add(car.getName()));
        validCarNames(nameList);
        this.cars = cars;
    }

    private void validCarNames(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameList.size() != nameSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
