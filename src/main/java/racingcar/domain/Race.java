package racingcar.domain;

import racingcar.generator.NumberGenerator;

import java.util.List;

public class Race {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Race(List<String> strings, NumberGenerator numberGenerator) {
        this.cars = strings.stream()
                .map(Car::of)
                .toList();
        this.numberGenerator = numberGenerator;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void process() {
        cars.forEach(car -> car.race(numberGenerator.generate()));
    }

    public List<String> winners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대 위치를 찾을 수 없습니다."));
    }

}
