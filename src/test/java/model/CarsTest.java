package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsTest {
    @Test
    void 자동차이름_중복() {
        List<Car> cars = new ArrayList<>();
        Car test = new Car("test");
        Car duplicated = new Car("test");

        cars.add(test);
        cars.add(duplicated);

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름을 넣었습니다.");
    }

    @Test
    void 자동차_하나만_입력_경우() {
        List<Car> cars = new ArrayList<>();
        Car car = new Car("test");

        cars.add(car);

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 2개 이상 입력해야 합니다.");
    }
}
