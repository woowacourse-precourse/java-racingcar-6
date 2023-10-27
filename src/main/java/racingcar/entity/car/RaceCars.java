package racingcar.entity.car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaceCars {
    private final List<Car> cars;

    public RaceCars(List<Car> cars) {
        this.cars = cars;
    }

    public int size(){
        return cars.size();
    }

    public Stream<Car> stream(){
        return cars.stream();
    }

    public String victoryCarName(){
        int max = maxCarMovementCount();
        return cars.stream()
                .filter(car -> car.getMoveCount() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int maxCarMovementCount(){
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max().orElse(0);
    }

}
