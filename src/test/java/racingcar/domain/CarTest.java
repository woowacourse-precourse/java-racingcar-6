package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void CarTest1() {
        String input = "abcdef";

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(input, new RandomNumberGenerator()));
    }

    @Test
    @DisplayName("자동차 이름이 5자이하면 예외가 발생하지 않는다.")
    void CarTest2() {
        String input = "abcde";

        Car car = new Car(input, new RandomNumberGenerator());
        Assertions.assertEquals(car.getName(), input);
    }

    @Test
    @DisplayName("무작위 값이 4이상이면 전진한다.")
    void CarTest3() {
        String input = "abcde";

        Car car = new Car(input, new FixedNumberGenerator(4));
        car.moveForward();
        Assertions.assertEquals(car.getPosition(), 1);
    }

    @Test
    @DisplayName("무작위 값이 4이하면 전진하지 않는다.")
    void CarTest4() {
        String input = "abcde";

        Car car = new Car(input, new FixedNumberGenerator(3));
        car.moveForward();
        Assertions.assertEquals(car.getPosition(), 0);
    }
}