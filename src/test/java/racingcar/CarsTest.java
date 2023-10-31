package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 객체_숫자_전달() {
        Car car = new Car("자동차");
        Cars cars = new Cars(List.of(car));
        cars.move();

        Car newCar = new Car("자동차");

        assertThat(car.equals(newCar)).isFalse();
    }
    @Test
    void 객체_결과_출력() {
        Car car = new Car("자동차");
        Cars cars = new Cars(List.of(car));
        cars.move();

        assertThatCode(cars::indicate).doesNotThrowAnyException();
    }
}
