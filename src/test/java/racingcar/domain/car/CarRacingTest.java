package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.output.CarRacingDto;
import racingcar.domain.move.MoveCommand;

final class CarRacingTest {

    // [함수명_상태_예상동작] 양식으로 테스트 함수명 지어보기
    @DisplayName("String 타입의 carName을 인자로 CarRacing을 생성할 수 있으며 생성 시, Coordinate 기본값은 0이다.")
    @Test
    void CarRacing_withCarName_shouldCreateInstance() {
        // given
        final String carName = "a";

        // when
        final CarRacing carRacing = new CarRacing(carName);
        final CarRacingDto carRacingDto = carRacing.toDto();

        // then
        assertThat(carRacingDto.carName()).isEqualTo(carName);
        assertThat(carRacingDto.coordinate()).isEqualTo(0);
    }

    @DisplayName("MoveCommand.GO로 CarRacing을 움직이면 coordinate가 증가한다.")
    @Test
    void moveBy_MoveCommandGO_shouldIncreaseCoordinate() {
        // given
        final String input1 = "a";

        // when
        final CarRacing carRacing1 = new CarRacing(input1);
        carRacing1.moveBy(MoveCommand.GO);
        final CarRacingDto carRacingDto = carRacing1.toDto();

        // then
        assertThat(carRacingDto.coordinate()).isEqualTo(1);
    }

    @DisplayName("moveBy의 인자로 MoveCommand.STAY 입력 시, coorindate는 변하지 않는다.")
    @Test
    void moveBy_MoveCommandSTAY_shouldNotIncreaseCoordinate() {
        // given
        final CarRacing carRacing1 = new CarRacing("a");

        // when
        carRacing1.moveBy(MoveCommand.STAY);
        final CarRacingDto carRacingDto = carRacing1.toDto();

        // then
        assertThat(carRacingDto.coordinate()).isEqualTo(0);
    }
}