package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {
    @Test
    @DisplayName("자동차 이름이 중복되면 예외가 발생한다.")
    void CarsTest1() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cars(List.of(car1, car2)));
    }
}