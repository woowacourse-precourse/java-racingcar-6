package racingcar.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("Car 객체 생성 확인")
    void initCar_생성() {
        Car car = new Car("asdf");

        Assertions.assertAll(
                () -> assertEquals("asdf", car.getCarName()),
                () -> assertEquals(0, car.getCarDistance())
        );
    }

    @Test
    @DisplayName("Car 객체 생성 예외 확인 - 이름 초과")
    void initCar_이름_초과_예외발생() {
        assertThatThrownBy(() -> new Car("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car 객체 생성 예외 확인 - 이름 없음")
    void initCar_이름_0글자_예외발생() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("4 이상일 경우 전진 확인")
    void moveForwardOrNotTest_전진() {
        Car car = new Car("asdf");

        assertAll(
                () -> car.moveForwardOrNot(4),
                () -> assertEquals(1, car.getCarDistance()),
                () -> car.moveForwardOrNot(9),
                () -> assertEquals(2, car.getCarDistance())
        );
    }

    @Test
    @DisplayName("4 미만일 경우 전진 안함")
    void moveForwardOrNotTest_전진안함() {
        Car car = new Car("asdf");

        assertAll(
                () -> car.moveForwardOrNot(3),
                () -> assertEquals(0, car.getCarDistance())
        );
    }
}
