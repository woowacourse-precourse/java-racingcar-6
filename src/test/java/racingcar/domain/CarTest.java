package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("이름의 길이가 6이면 IllegalArgumentException이 발생한다.")
    void 이름_길이_초과_예외_() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("sixSix"));
    }

    @Test
    @DisplayName("이름의 길이가 5면 IllegalArgumentException이 발생하지 않는다.")
    void CarTest() {
        Car car = new Car("fives");
    }
}