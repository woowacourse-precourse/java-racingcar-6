package racingcar.domain.game.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarMovementDto;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        Car audi = Car.from(CarName.from("audi"));
        Car benz = Car.from(CarName.from("benz"));
        Car bmw = Car.from(CarName.from("bmw"));

        List<Car> carList = List.of(audi, benz, bmw);
        cars = Cars.from(carList);
    }

    @DisplayName("Cars 객체를 생성할 수 있는지 검증")
    @Test
    void should_Create_Cars() {
        assertThat(cars).isNotNull();
    }

    @DisplayName("Car가 전진 조건을 만족해서 움직인다면, 각 자동차의 position은 1이어야 한다")
    @Test
    void should_Move_Cars_If_Condition_Met() {
        // given
        FixedMoveStrategy fixedMoveStrategy = new FixedMoveStrategy(true);

        // when
        CarsMovementDto carsMovementDto = cars.moveOnce(fixedMoveStrategy);

        // then
        List<CarMovementDto> carMovementDtos = carsMovementDto.carsMovementDto();
        assertThat(carMovementDtos.size()).isEqualTo(3);
        for (CarMovementDto carMovementDto : carMovementDtos) {
            assertThat(carMovementDto.position()).isEqualTo(1);
        }
    }

    @DisplayName("Car가 전진 조건을 만족하지 않는다면, 각 자동차의 position은 0이어야 한다")
    @Test
    void should_Not_Move_Cars_If_Condition_Not_Met() {
        // given
        FixedMoveStrategy fixedMoveStrategy = new FixedMoveStrategy(false);

        // when
        CarsMovementDto carsMovementDto = cars.moveOnce(fixedMoveStrategy);

        // then
        List<CarMovementDto> carMovementDtos = carsMovementDto.carsMovementDto();
        assertThat(carMovementDtos.size()).isEqualTo(3);
        for (CarMovementDto carMovementDto : carMovementDtos) {
            assertThat(carMovementDto.position()).isEqualTo(0);
        }
    }

    @DisplayName("최종 우승자를 가려내는지 검증")
    @Test
    void should_Determine_Final_Winners() {
        // given
        cars.getCars().get(0).moveOnce();
        cars.getCars().get(1).moveOnce();

        // when
        WinnersDto winnersDto = cars.toWinnerDto();

        // then
        assertThat(winnersDto).isNotNull();
        assertThat(winnersDto.winners()).isEqualTo("audi, benz");
    }
}