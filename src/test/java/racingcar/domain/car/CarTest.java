package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.MoveResult;

final class CarTest {

    @DisplayName("moved를 N번 호출하면 coordinate는 N이다")
    @Test
    void carMovedTest() {
        // given
        final String carName1 = "a";
        final Car car = new Car(carName1);
        final int n = 100;

        // when
        // then
        for (int i = 1; i <= n; i++) {
            final MoveResult moveResult = car.moved();
            assertThat(moveResult.carName()).isEqualTo(carName1);
            assertThat(moveResult.coordinate()).isEqualTo(i);
        }

    }
}