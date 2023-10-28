package racingcar.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Participants {
    private final List<Car> cars;

    public Participants(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void raceNTimes(int times) {
        validate(times);
        IntStream.range(0, times)
                .forEach(unused -> race());
    }

    private void validate(int times) {
        if (times < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
        }
    }

    private void race() {
        cars.forEach(Car::moveForward);
    }
}
