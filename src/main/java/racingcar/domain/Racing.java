package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private int attemptCount;
    private final List<Car> cars;

    public Racing() {
        this.attemptCount = 0;
        this.cars = new ArrayList<>();
    }

    void setCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    void setAttemptCount(String count) {
        attemptCount = Integer.parseInt(count);
    }

    int getAttemptCount() {
        return attemptCount;
    }

    List<Car> getCars() {
        return cars;
    }

    void runCarsOnce() {
        for (Car car : cars) {
            car.run();
        }
    }

    private int getMaxSteps() {
        return cars.stream()
                .map(Car::getStep)
                .mapToInt(x -> x)
                .max()
                .orElse(0);
    }

    private List<String> getWinnerList(int max) {
        return cars.stream()
                .filter(car -> car.getStep() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    String getWinners() {
        int max = getMaxSteps();
        List<String> winnerList = getWinnerList(max);

        return String.join(", ", winnerList);
    }
}
