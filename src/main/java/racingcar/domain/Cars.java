package racingcar.domain;

import racingcar.util.RacingCarGameUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> value;
    private Cars(List<Car> values) {
        this.value = values;
    }

    private final Car findMaxPosition() {
        return value.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력 값 입니다."));
    }

    public final List<Car> getWinner() {
        return Collections.unmodifiableList(value.stream()
                .filter(car -> car.isEqualPosition(findMaxPosition()))
                .collect(Collectors.toList()));
    }

    public final void moveCars() {
        value.stream()
                .forEach(car -> car.changePosition(RacingCarGameUtil.getRandomNumber()));
    }

    public static final Cars from(List<String> values) {
        return new Cars(values.stream()
                .map(value -> Car.from(value))
                .collect(Collectors.toList()));
    }
    public void getStatus() {
        value.forEach(car -> RacingCarGameUtil.viewCarStatus(car.getName(), car.getPosition()));
    }
}
