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
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여하는 자동차 리스트를 입력해야 합니다.");
        }

        long uniqueNamesCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (uniqueNamesCount != cars.size()) {
            throw new IllegalArgumentException("중복된 이름의 자동차가 있습니다.");
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
