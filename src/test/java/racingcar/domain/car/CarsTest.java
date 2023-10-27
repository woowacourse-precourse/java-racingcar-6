package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.input.CreateCarsRacing;
import racingcar.domain.car.dto.output.CarRacingDto;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.move.MoveCommand;
import racingcar.domain.move.MoveCommander;
import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.NoCarsException;

final class CarsTest {

    @DisplayName("moveAllBy 호출 시, MoveCommand.GO가 생성되면 모든 Car의 coodrinate가 1씩 증가한다.")
    @Test
    void moveAllByGoCommand() {
        // given
        final CreateCarsRacing createCarsRacing = new CreateCarsRacing(List.of("a", "b", "c"));
        final CarsRacing cars = CarsRacing.from(createCarsRacing);
        final MoveCommander go = new FixedMoveCommander(MoveCommand.GO);

        // when
        cars.moveAllBy(go);
        final CarsRacingDto dto = cars.toDto();
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
    void moveAllByStayCommand() {
        // given
        final CreateCarsRacing createCarsRacing = new CreateCarsRacing(List.of("a", "b", "c"));
        final CarsRacing cars = CarsRacing.from(createCarsRacing);
        final MoveCommander stay = new FixedMoveCommander(MoveCommand.STAY);

        // when
        cars.moveAllBy(stay);
        final CarsRacingDto dto = cars.toDto();
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

    @DisplayName("중복 없는 차 이름으로 Cars 생성 가능")
    @Test
    void createCarsSuccess() {
        // given
        final String carName1 = "a";
        final String carName2 = "b";
        final String carName3 = "c";
        final List<String> carNames = List.of(carName1, carName2, carName3);
        final CreateCarsRacing createCarsRacing = new CreateCarsRacing(carNames);

        // when
        final CarsRacing cars = CarsRacing.from(createCarsRacing);

        // then
        assertThat(createCarsRacing.carNames().size()).isEqualTo(3);
        assertThat(createCarsRacing.carNames().get(0)).isEqualTo(carName1);
        assertThat(createCarsRacing.carNames().get(1)).isEqualTo(carName2);
        assertThat(createCarsRacing.carNames().get(2)).isEqualTo(carName3);
        assertThat(cars).isNotNull();
    }

    @DisplayName("입력된 차 이름이 하나도 없으면 생성하면 예외 발생")
    @Test
    void createCarsFailure2() {
        // given
        final List<String> carNames = List.of();

        // when
        // then
        assertThatThrownBy(
                () -> new CreateCarsRacing(carNames)
        )
                .isInstanceOf(NoCarsException.class)
                .hasMessage(NoCarsException.NO_CARS_EXCEPTION_MESSAGE);
    }

    @DisplayName("중복된 이름을 가진 CreateCars를 생성하면 예외 발생")
    @Test
    void createCarsDtoFailure() {
        // given
        final String carName1 = "a";
        final String carName2 = "a";
        final String carName3 = "b";
        final List<String> carNames = List.of(carName1, carName2, carName3);

        // when
        // then
        assertThatThrownBy(
                () -> new CreateCarsRacing(carNames)
        )
                .isInstanceOf(DuplicateCarNameException.class)
                .hasMessage(DuplicateCarNameException.DUPLICATE_CAR_NAME_EXCEPTION_MESSAGE);
    }
}