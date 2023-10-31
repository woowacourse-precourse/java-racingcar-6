package racingcar.domain.car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.racing.MoveStrategy;

public class CarManager {
    private List<Car> cars;
    private final MoveStrategy moveStrategy;

    public CarManager(String input, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        parseCarNames(input);
    }

    private void parseCarNames(String input) {
        Set<String> uniqueNames = new HashSet<>();
        List<Car> cars = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(name -> createCar(name, uniqueNames))
                .collect(Collectors.toList());
        this.cars = cars;
    }

    private Car createCar(String name, Set<String> uniqueNames) {
        if (!uniqueNames.add(name)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + name);
        }
        return new Car(name, moveStrategy);
    }

    public List<Car> getCars() {
        return cars;
    }
}