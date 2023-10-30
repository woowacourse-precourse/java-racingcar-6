package racingcar.domain;

import java.util.List;

/**
 * 같은 Race 를 하는 Car 들을 모아놓은 컬렉션
 */

public record Cars(List<Car> cars) {

    public Cars(final List<Car> cars) {
        this.cars = List.copyOf(cars);
    }
}
