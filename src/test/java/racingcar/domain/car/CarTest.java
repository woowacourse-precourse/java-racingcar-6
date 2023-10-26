package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.MoveResult;
import racingcar.domain.move.MoveCommand;

final class CarTest {
    @DisplayName("Car가 움직이지 않으면 coordinate는 0이다")
    @Test
    void carNotMovedTest() {
        // given
        final String carName1 = "a";
        final Car car = new Car(carName1);

        // when
        final MoveResult moveResult = car.movedBy(MoveCommand.STAY);

        // then
        assertThat(moveResult.carName()).isEqualTo(carName1);
        assertThat(moveResult.coordinate()).isEqualTo(0);

    }

    @DisplayName("MoveCommand.STAY 명령으로 N번 moved 해도 coordinate는 0이다")
    @Test
    void carStayTest() {
        // given
        final String carName1 = "a";
        final Car car = new Car(carName1);
        final int n = 100;

        // when
        // then
        for (int i = 1; i <= n; i++) {
            final MoveResult moveResult = car.movedBy(MoveCommand.STAY);
            assertThat(moveResult.carName()).isEqualTo(carName1);
            assertThat(moveResult.coordinate()).isEqualTo(0);
        }

    }

    @DisplayName("MoveCommand.GO 명령과 함께 N번 moved하면 coordinate는 N이다")
    @Test
    void carMovedTest() {
        // given
        final String carName1 = "a";
        final Car car = new Car(carName1);
        final int n = 100;

        // when
        // then
        for (int i = 1; i <= n; i++) {
            final MoveResult moveResult = car.movedBy(MoveCommand.GO);
            assertThat(moveResult.carName()).isEqualTo(carName1);
            assertThat(moveResult.coordinate()).isEqualTo(i);
        }

    }
}