package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @Test
    void 자동차가_만들어진_순간에_움직인_거리는_0이어야_한다() {
        // given
        final String expectedName = "abcde";
        // when
        final Car actualCar = new Car(expectedName, () -> true);
        // then
        assertAll(() -> assertThat(actualCar.getName().length()).isLessThanOrEqualTo(5),
                () -> assertThat(actualCar.getMovementDistance()).isEqualTo(0));
    }

    @Test
    void 자동차_이름은_5글자를_초과할_수_없다() {
        // given
        final String expectedName = "abcdef";
        // when
        // then
        assertThatThrownBy(() -> new Car(expectedName, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car name length must be less than 5 characters");
    }

    @ParameterizedTest
    @CsvSource(value = {"true, 1", "false, 0"})
    void 자동차는_움직이는_전략_조건이_참인_경우에만_전진한다(boolean isMovable, int expectedMovement) {
        // given
        final Car car = new Car("jinn", () -> isMovable);
        // when
        final Car actualCar = car.move();
        // then
        assertThat(actualCar.getMovementDistance()).isEqualTo(expectedMovement);
    }
}