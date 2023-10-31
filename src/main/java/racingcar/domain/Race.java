package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int totalRounds;
    private int currentRound;

    public Race(List<Car> cars, int rounds) {
        validateInputs(cars, rounds);

        this.cars = cars;
        this.totalRounds = rounds;
    }

    public void runRound() {
        for (Car car : cars) {
            car.move();
        }
        currentRound++;
    }

    public boolean isFinished() {
        return currentRound >= totalRounds;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateInputs(List<Car> cars, int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 양수 여야만 합니다.");
        }

        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여하는 자동차는 한 대 이상 이여 야만 합니다");
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
