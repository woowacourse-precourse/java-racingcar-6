package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.output.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("moveChecker forward로 지정시, moveBy메서드 호출하면 앞으로 한 칸 이동")
    void moveOnePosition() {
        //given
        Car car = new Car("a");
        MoveChecker moveChecker = new ManualMoveChecker(MoveInstruction.FORWARD);
        //when
        car.moveBy(moveChecker);
        CarDto carDto = car.toCarDto();
        //then
        assertThat(carDto.name()).isEqualTo("a");
        assertThat(carDto.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("moveChecker stay로 지정시, moveBy메서드 호출하면 이동x")
    void stayAtPosition() {
        //given
        Car car = new Car("a");
        MoveChecker moveChecker = new ManualMoveChecker(MoveInstruction.STAY);
        //when
        car.moveBy(moveChecker);
        CarDto carDto = car.toCarDto();
        //then
        assertThat(carDto.name()).isEqualTo("a");
        assertThat(carDto.position()).isEqualTo(0);
    }
}