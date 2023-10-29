package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Participants {
    private final List<Car> cars;
    private RaceHistory raceHistory;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants from(List<String> names) {
        return new Participants(names.stream().map(Car::new).toList());
    }

    public RaceHistory raceNTimes(int times) {
        validate(times);
        raceHistory = new RaceHistory(cars);

        IntStream.range(0, times)
                .forEach(unused -> race());

        return raceHistory;
    }

    private void validate(int times) {
        if (times < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
        }
    }

    private void race() {
        cars.forEach(Car::moveForward);
        raceHistory.record(cars);
    }

    public List<String> getWinners() {
        List<Car> candidates = new ArrayList<>(cars);
        Collections.sort(candidates);
        int first = candidates.get(0).getPosition();
        return candidates.stream()
                .filter(car -> car.getPosition() == first)
                .map(Car::getName)
                .toList();
    }
}
