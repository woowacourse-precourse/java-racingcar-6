package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int WINNER_INDEX = 0;

    private final List<Car> cars;

    public Players(List<String> names) {
        validateDuplicateName(names);

        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateDuplicateName(List<String> carNames) {
        int uniqueCarNameCount = (int) carNames.stream()
                .distinct()
                .count();

        if (uniqueCarNameCount != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> findWinner() {
        Collections.sort(cars);
        Car winner = cars.get(WINNER_INDEX);

        List<String> winnersName = cars.stream()
                .filter(car -> car.isSameProgress(winner))
                .map(Car::getName)
                .collect(Collectors.toList());

        return winnersName;
    }

    public List<Car> getCars() {
        return cars;
    }
}
