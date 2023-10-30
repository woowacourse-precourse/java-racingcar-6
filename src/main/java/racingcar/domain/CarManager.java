package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CarManager {
    private final List<Car> carList;

    public CarManager(List<Car> carList) {
        this.carList = carList;
    }

    public String findWinner() {
        List<Car> winner = carList.stream()
                .collect(Collectors.groupingBy(Car::getMoveStatus))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Entry::getKey))
                .map(Entry::getValue)
                .orElse(new ArrayList<>()); //좀 간단하게 할 수 있는 방법을 찾아보자.

        return winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
