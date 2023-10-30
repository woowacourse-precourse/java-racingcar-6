package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @Test
    @DisplayName("5글자 이하의 자동차가 만들어진 순간에 움직인 거리는 0이어야 한다.")
    void createCarTest() {
        // given
        final String expectedName = "abcde";
        // when
        final Car actualCar = new Car(expectedName, () -> true);
        // then
        assertAll(() -> assertThat(actualCar.getName().length()).isLessThanOrEqualTo(5),
                () -> assertThat(actualCar.getMovementDistance()).isEqualTo(0));
    }

    @Test
    @DisplayName("자동차 이름은 5글자를 초과할 수 없다.")
    void carNameValidateTest() {
        // given
        final String expectedName = "abcdef";
        // when
        // then
        assertThatThrownBy(() -> new Car(expectedName, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car name length must be less than 5 characters");
    }

    @ParameterizedTest
    @DisplayName("자동차는 움직이는 전략 조건이 참인 경우에만 전진한다.")
    @CsvSource(value = {"true, 1", "false, 0"})
    void movableStrategyTest(boolean isMovable, int expectedMovement) {
        // given
        final Car car = new Car("jinn", () -> isMovable);
        // when
        final Car actualCar = car.move();
        // then
        assertThat(actualCar.getMovementDistance()).isEqualTo(expectedMovement);
    }
}