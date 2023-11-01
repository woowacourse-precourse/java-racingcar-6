package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final int MOVABLE_NUMBER = 4;
    private static final int IMMOVABLE_NUMBER = 3;

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진")
    void When_NumberIs4OrMore_Expect_Move() {
        // given
        Car car = new Car("pobi");

        // when
        car.MoveOrStop(MOVABLE_NUMBER);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 정지")
    void When_NumberIsLessThan4_Expect_Stop() {
        // given
        Car car = new Car("pobi");

        // when
        car.MoveOrStop(IMMOVABLE_NUMBER);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
