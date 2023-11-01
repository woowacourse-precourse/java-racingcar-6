package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public final class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void attempt() {
        for (Car car : cars) {
            car.attempt();
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Car car : cars) {
            stringJoiner.add(car.toString());
        }
        return stringJoiner.toString();
    }

    public String winners() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        Integer winnerPosition = calculateWinnerPosition();
        for (Car car : cars) {
            Integer carPosition = car.getPosition();
            if (carPosition >= winnerPosition) {
                stringJoiner.add(car.getName());
            }
        }
        return stringJoiner.toString();
    }

    private Integer calculateWinnerPosition() {
        Integer winnerPosition = 0;
        for (Car car : cars) {
            Integer carPosition = car.getPosition();
            if (carPosition > winnerPosition) {
                winnerPosition = carPosition;
            }
        }
        return winnerPosition;
    }
}
