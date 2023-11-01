package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.dto.output.CarDto;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("jii");
    }

    private MoveInstruction getMoveInstruction(int number) {
        if (number < 4) {
            return MoveInstruction.STAY;
        }
        return MoveInstruction.FORWARD;
    }

    @Test
    @DisplayName("성공 - Car 객체 생성")
    void create_Car() {
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"4,jii", "5,jii", "6,jii", "7,jii", "8,jii", "9,jii"})
    @DisplayName("성공 - moveChecker forward로 지정시, moveBy메서드 호출하면 앞으로 한 칸 이동")
    void move_OnePosition(int number, String expectedName) {
        //given
        MoveInstruction moveInstruction = getMoveInstruction(number);
        MoveChecker moveChecker = new ManualMoveChecker(moveInstruction);
        //when
        car.moveBy(moveChecker);
        CarDto carDto = car.toCarDto();
        //then
        assertThat(carDto.name()).isEqualTo(expectedName);
        assertThat(carDto.position()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"0,jii", "1,jii", "2,jii", "3,jii"})
    @DisplayName("성공 - moveChecker stay로 지정시, moveBy메서드 호출하면 이동x")
    void stay_At_Position(int number, String expectedName) {
        //given
        MoveInstruction moveInstruction = getMoveInstruction(number);
        MoveChecker moveChecker = new ManualMoveChecker(moveInstruction);
        //when
        car.moveBy(moveChecker);
        CarDto carDto = car.toCarDto();
        //then
        assertThat(carDto.name()).isEqualTo(expectedName);
        assertThat(carDto.position()).isEqualTo(0);
    }
}