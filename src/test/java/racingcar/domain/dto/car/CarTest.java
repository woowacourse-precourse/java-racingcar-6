package racingcar.domain.dto.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.CarDto;
import racingcar.domain.car.Car;
import racingcar.domain.move.Move;

final class CarTest {
    @DisplayName("FORWARD로 Car를 움직이면 position 1 증가")
    @Test
    void carMoveBy_FORWARD_shouldIncreasePositionOne() {
        // given
        final Car a = Car.from("a");

        // when
        a.moveBy(Move.FORWARD);
        final CarDto carDto = a.toCarDto();

        // then
        assertThat(carDto.name()).isEqualTo("a");
        assertThat(carDto.position()).isEqualTo(1);
    }

    @DisplayName("STAY로 Car를 움직이면 position 증가 X")
    @Test
    void carMoveBy_STAY_shouldNotIncreasePosition() {
        // given
        final Car a = Car.from("a");

        // when
        a.moveBy(Move.STAY);
        final CarDto carDto = a.toCarDto();

        // then
        assertThat(carDto.name()).isEqualTo("a");
        assertThat(carDto.position()).isEqualTo(0);
    }
}