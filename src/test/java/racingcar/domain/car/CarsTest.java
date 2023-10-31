package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.input.CreateCarsRacing;
import racingcar.domain.car.dto.output.CarRacingDto;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.move.MoveCommand;
import racingcar.domain.move.MoveCommander;

final class CarsTest {

    @DisplayName("moveAllBy 호출 시, MoveCommand.GO가 생성되면 모든 Car의 coodrinate가 1씩 증가한다.")
    @Test
    void moveAllBy_withGoCommand_shouldIncreaseCoordinateOfAllCar() {
        // given
        final CreateCarsRacing createCarsRacing = new CreateCarsRacing(List.of("a", "b", "c"));
        final CarsRacing cars = CarsRacing.from(createCarsRacing);
        final MoveCommander go = new FixedMoveCommander(MoveCommand.GO);

        // when
        cars.moveAllBy(go);
        final CarsRacingDto dto = cars.toCarsRacingDto();
        final CarRacingDto first = dto.carRacing().get(0);
        final CarRacingDto second = dto.carRacing().get(1);
        final CarRacingDto third = dto.carRacing().get(2);

        // then
        assertThat(first.carName())
                .isEqualTo("a");
        assertThat(first.coordinate())
                .isEqualTo(1);

        assertThat(second.carName())
                .isEqualTo("b");
        assertThat(first.coordinate())
                .isEqualTo(1);

        assertThat(third.carName())
                .isEqualTo("c");
        assertThat(first.coordinate())
                .isEqualTo(1);
    }

    @DisplayName("moveAllBy 호출 시, MoveCommand.STAY가 생성되면 모든 Car의 coodrinate가 그대로 유지된다")
    @Test
    void moveAllBy_withStayCommand_shouldNotIncreaseCoordinateOfAllCar() {
        // given
        final CreateCarsRacing createCarsRacing = new CreateCarsRacing(List.of("a", "b", "c"));
        final CarsRacing cars = CarsRacing.from(createCarsRacing);
        final MoveCommander stay = new FixedMoveCommander(MoveCommand.STAY);

        // when
        cars.moveAllBy(stay);
        final CarsRacingDto dto = cars.toCarsRacingDto();
        final CarRacingDto first = dto.carRacing().get(0);
        final CarRacingDto second = dto.carRacing().get(1);
        final CarRacingDto third = dto.carRacing().get(2);

        // then
        assertThat(first.carName())
                .isEqualTo("a");
        assertThat(first.coordinate())
                .isEqualTo(0);

        assertThat(second.carName())
                .isEqualTo("b");
        assertThat(first.coordinate())
                .isEqualTo(0);

        assertThat(third.carName())
                .isEqualTo("c");
        assertThat(first.coordinate())
                .isEqualTo(0);
    }

}