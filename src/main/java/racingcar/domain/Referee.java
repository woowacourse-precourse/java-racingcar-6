package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Referee {
    public static String findWinner(Cars cars) {
        List<Car> winner = cars.getCarList().stream()
                .collect(Collectors.groupingBy(Car::getMoveStatus))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Entry::getKey))
                .map(Entry::getValue)
                .orElse(new ArrayList<>());

        return winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
