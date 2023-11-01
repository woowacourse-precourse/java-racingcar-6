package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.output.CarRacingDto;
import racingcar.domain.move.MoveCommand;

final class CarTest {
    @DisplayName("Car가 움직이지 않으면 coordinate는 0이다")
    @Test
    void moveBy_withSTAYCommand_shouldNotMoveCar() {
        // given
        final String carName1 = "a";
        final CarRacing car = new CarRacing(carName1);

        // when
        car.moveBy(MoveCommand.STAY);
        final CarRacingDto dto = car.toDto();

        // then
        assertThat(dto.carName()).isEqualTo(carName1);
        assertThat(dto.coordinate()).isEqualTo(0);

    }

    @DisplayName("MoveCommand.STAY 명령으로 N번 moved 해도 coordinate는 0이다")
    @Test
    void moveBy_withSTAYCommandManyTimes_shouldNotMoveCar() {
        // given
        final String carName1 = "a";
        final CarRacing car = new CarRacing(carName1);
        final int n = 100;

        // when
        // then
        for (int i = 1; i <= n; i++) {
            car.moveBy(MoveCommand.STAY);
            final CarRacingDto dto = car.toDto();
            assertThat(dto.carName()).isEqualTo(carName1);
            assertThat(dto.coordinate()).isEqualTo(0);
        }

    }

    @DisplayName("MoveCommand.GO 명령과 함께 N번 moved하면 coordinate는 N이다")
    @Test
    void moveBy_withGOCommandManyNTimes_shouldIncreaseCoordinateN() {
        // given
        final String carName1 = "a";
        final CarRacing car = new CarRacing(carName1);
        final int n = 100;

        // when
        // then
        for (int i = 1; i <= n; i++) {
            car.moveBy(MoveCommand.GO);
            final CarRacingDto dto = car.toDto();
            assertThat(dto.carName()).isEqualTo(carName1);
            assertThat(dto.coordinate()).isEqualTo(i);
        }

    }
}