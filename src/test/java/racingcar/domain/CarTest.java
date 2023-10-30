package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void CarTest1() {
        String input = "abcdef";

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(input));
    }

    @Test
    @DisplayName("자동차 이름이 5자이하면 예외가 발생하지 않는다.")
    void CarTest2() {
        String input = "abcde";

        Car car = new Car(input);
        Assertions.assertEquals(car.getName(), input);
    }
}