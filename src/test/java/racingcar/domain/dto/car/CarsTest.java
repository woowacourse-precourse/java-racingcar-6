package racingcar.domain.dto.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.dto.RoundDto;
import racingcar.controller.dto.WinnersDto;
import racingcar.domain.car.Cars;
import racingcar.domain.move.Move;
import racingcar.domain.move.MovePicker;
import racingcar.fixed.FixedMovePicker;
import racingcar.fixed.QueuedMovePicker;

final class CarsTest {

    @DisplayName("FORWARD로 Cars.moveAllBy 호출 시, 모든 position 1 증가")
    @Test
    void moveAllBy_FORWARD_shouldIncreasePositions() {
        // given
        final MovePicker movePicker = new FixedMovePicker(Move.FORWARD);
        final Cars cars = Cars.from("a,b,c");

        // when
        cars.moveAllBy(movePicker);
        final RoundDto roundDto = cars.toRoundDto();

        // then
        assertThat(roundDto.cars().get(0).position())
                .isEqualTo(1);
        assertThat(roundDto.cars().get(1).position())
                .isEqualTo(1);
        assertThat(roundDto.cars().get(2).position())
                .isEqualTo(1);
    }

    @DisplayName("STAY로 Cars.moveAllBy 호출 시, 모든 position 증가 x")
    @Test
    void test() {
        // given
        final MovePicker movePicker = new FixedMovePicker(Move.STAY);
        final Cars cars = Cars.from("a,b,c");

        // when
        cars.moveAllBy(movePicker);
        final RoundDto roundDto = cars.toRoundDto();

        // then
        assertThat(roundDto.cars().get(0).position())
                .isEqualTo(0);
        assertThat(roundDto.cars().get(1).position())
                .isEqualTo(0);
        assertThat(roundDto.cars().get(2).position())
                .isEqualTo(0);
    }

    @DisplayName("winners는 모든 Car 중 가장 높은 position을 가져야 한다.")
    @Test
    void winners_shouldHasMaxPosition() {
        // given
        final MovePicker movePicker = new QueuedMovePicker(
                Move.FORWARD,
                Move.FORWARD,
                Move.STAY
        );
        final Cars cars = Cars.from("a,b,c");

        // when
        cars.moveAllBy(movePicker);
        final WinnersDto winnersDto = cars.toWinnersDto();

        // then
        assertThat(winnersDto.winners().size())
                .isEqualTo(2);

        assertThat(winnersDto.winners().get(0).name())
                .isEqualTo("a");

        assertThat(winnersDto.winners().get(1).name())
                .isEqualTo("b");
    }
}