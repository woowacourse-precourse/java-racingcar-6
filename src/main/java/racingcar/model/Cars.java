package racingcar.model;

import racingcar.view.input.ErrorConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ErrorConstants.NO_CAR_ERROR);
        }
        cars = Arrays.stream(carNames)
                .map((name) -> new Car(name))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Cars makeCarsByNames(String[] carNames) {
        return new Cars(carNames);
    }

    public void tryCars() {
        for (Car car : cars) {
            car.advanceOrStop();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car)
                    .append("\n");
        }
        return sb.toString();
    }

    public String findWinner() {
        Integer winnerPosition = -1;
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winnerNames.add(car.getName());
            }
            if (car.getPosition() > winnerPosition) {
                winnerPosition = car.getPosition();
                winnerNames.clear();
                winnerNames.add(car.getName());
            }
        }
        return String.join(", ", winnerNames);
    }
}
