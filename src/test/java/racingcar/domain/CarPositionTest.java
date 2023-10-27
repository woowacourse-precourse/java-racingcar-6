package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarPositionTest {

    @Nested
    @DisplayName("움직임 테스트")
    class MovingTest {

        @ParameterizedTest(name = "횟수 : {0}")
        @CsvSource({"0", "1", "10"})
        @DisplayName("움직인 횟수를 셀 수 있다")
        void moveTest(int count) {
            CarPosition position = CarPosition.create();

            moveRepeat(position, count);

            assertThat(position.getPosition()).isEqualTo(count);
        }

        void moveRepeat(CarPosition position, int count) {
            for (int time = 0; time < count; time++) {
                position.move();
            }
        }
    }
}