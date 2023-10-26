package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {
    @Nested
    @DisplayName("자동차 이동")
    class Move {
        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("부여받은 연료가 4 이상이면 자동차는 전진한다")
        void moveForward(final int fuel) {
            // given
            final Car car = new Car("pobi");
            final Position previousPosition = car.getPosition();

            // when
            car.moveForward(fuel);

            // then
            assertThat(car.getPosition().getValue()).isEqualTo(previousPosition.getValue() + 1);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("부여받은 연료가 4 미만이면 자동차는 정지한다")
        void stop(final int fuel) {
            // given
            final Car car = new Car("pobi");
            final Position previousPosition = car.getPosition();

            // when
            car.moveForward(fuel);

            // then
            assertThat(car.getPosition().getValue()).isEqualTo(previousPosition.getValue());
        }
    }

    @Test
    @DisplayName("동일한 자동차인지 확인한다 (CarName을 통한 equals)")
    void equals() {
        // given
        final Car car1 = new Car("pobi");
        final Car car2 = new Car("pobi");
        final Car car3 = new Car("pobi2");

        // when
        final boolean actual1 = car1.equals(car2);
        final boolean actual2 = car1.equals(car3);
        final boolean actual3 = car2.equals(car3);

        // then
        assertAll(
                () -> assertThat(actual1).isTrue(),
                () -> assertThat(actual2).isFalse(),
                () -> assertThat(actual3).isFalse()
        );
    }
}
