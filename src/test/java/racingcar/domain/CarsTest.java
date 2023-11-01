package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.dto.input.CarsRequestDto;
import racingcar.domain.dto.output.CarDto;
import racingcar.domain.dto.output.CarsDto;
import racingcar.domain.dto.output.WinnerDto;
import racingcar.domain.dto.output.WinnersDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNameList = new CarsRequestDto(List.of("a", "b", "c")).carNameList();
        cars = Cars.from(carNameList);
    }

    @Test
    @DisplayName("성공 - Cars 객체 생성")
    void create_Cars() {
        assertThat(cars).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"3,3,3", "1,1,3"})
    @DisplayName("성공 - n번의 시도동안 자동차들을 전진시켜주었을 때 dto(name, position) 검증")
    void validate_Value_Of_CarsDto_After_Move(int tryTimes, int expectedPosition, int carCount) {
        //when
        MoveChecker manualMoveChecker = new ManualMoveChecker(MoveInstruction.FORWARD);

        for (int i = 0; i < tryTimes; i++) {
            cars.moveCarsBy(manualMoveChecker);
        }

        CarsDto carsDto = cars.toCarsDto();

        //then
        assertThat(cars).extracting("carList").isNotNull();
        for (CarDto carDto : carsDto.carDtoList()) {
            assertThat(carDto.position()).isEqualTo(expectedPosition);
        }
        assertThat(carsDto.carDtoList()).hasSize(carCount);
    }

    @ParameterizedTest
    @CsvSource({"3,0,3"})
    @DisplayName("성공 - n번의 시도동안 자동차들을 전진하지 않았을 때 dto(name, position) 검증")
    void validate_Value_Of_CarsDto_After_Stay(int tryTimes, int expectedPosition, int carCount) {
        //when
        MoveChecker manualMoveChecker = new ManualMoveChecker(MoveInstruction.STAY);

        for (int i = 0; i < tryTimes; i++) {
            cars.moveCarsBy(manualMoveChecker);
        }

        CarsDto carsDto = cars.toCarsDto();

        //then
        assertThat(cars).extracting("carList").isNotNull();
        for (CarDto carDto : carsDto.carDtoList()) {
            assertThat(carDto.position()).isEqualTo(expectedPosition);
        }
        assertThat(carsDto.carDtoList()).hasSize(carCount);
    }

    @ParameterizedTest
    @CsvSource({"3,a,b,c"})
    @DisplayName("성공 - 자동차들 n번 전진했을 때 우승자 리스트 검증")
    void test(int tryTimes, WinnerDto expectedWinner) {
        //when
        MoveChecker manualMoveChecker = new ManualMoveChecker(MoveInstruction.FORWARD);

        for (int i = 0; i < tryTimes; i++) {
            cars.moveCarsBy(manualMoveChecker);
        }

        WinnersDto winnersDto = cars.toWinnersDto();

        //then
        assertThat(winnersDto.winners()).contains(expectedWinner);
    }
}