package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름이 null인 경우 예외 발생")
    void carNameBlankExceptionTest(final String name) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> Car.zeroPositionFrom(name));
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과한 경우 예외 발생")
    void carNameLengthOverValidationExceptionTest() {
        // given
        final String name = "car name test";

        // expected
        assertThrows(IllegalArgumentException.class, () -> Car.zeroPositionFrom(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("올바른 이름인 경우 정상 동작")
    void validCarTest(final String name) {
        // expected
        assertDoesNotThrow(() -> Car.zeroPositionFrom(name));
    }

    @Test
    @DisplayName("이동 변수가 참인 경우 이동한다")
    void canMoveTest() {
        // given
        Car car = Car.zeroPositionFrom("T");
        MovingStrategy strategy = () -> true;

        // when
        car.move(strategy);

        // then
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("이동 변수가 거짓인 경우 이동하지 않는다")
    void canNotMoveTest() {
        // given
        Car car = Car.zeroPositionFrom("T");
        MovingStrategy strategy = () -> false;

        // when
        car.move(strategy);

        // then
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("같은 위치라면 참을 반환하는 테스트")
    void isSamePositionTrueTest() {
        // given
        Car car = Car.zeroPositionFrom("T");
        int carPosition = 0;

        // when
        boolean actual = car.isSamePosition(carPosition);

        // then
        assertTrue(actual);
    }

    @Test
    @DisplayName("같은 위치가 아니라면 거짓을 반환하는 테스트")
    void isSamePositionFalseTest() {
        // given
        Car car = Car.zeroPositionFrom("T");
        int carPosition = 1;

        // when
        boolean actual = car.isSamePosition(carPosition);

        // then
        assertFalse(actual);
    }
}