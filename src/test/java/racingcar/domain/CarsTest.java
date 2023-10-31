package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("moveAll 할 때 canMove가 true면 차가 전진함")
    @Test
    void testMoveAllCars1() {
        // given
        Cars cars = new Cars(List.of("a", "b", "c"));
        Movable movable = new FixedMovable(true);

        // when
        cars.moveAllCars(movable);

        // then
        CarsDto carsDto = cars.toCarsDto();
        for (CarDto carDto : carsDto.cars()) {
            assertThat(carDto.position()).isEqualTo(1);
        }
    }

    @DisplayName("moveAll 할 때 canMove가 false면 차가 전진하지 않음")
    @Test
    void testMoveAllCars2() {
        // given
        Cars cars = new Cars(List.of("a", "b", "c"));
        Movable movable = new FixedMovable(false);

        // when
        cars.moveAllCars(movable);

        // then
        CarsDto carsDto = cars.toCarsDto();
        for (CarDto carDto : carsDto.cars()) {
            assertThat(carDto.position()).isEqualTo(0);
        }
    }

    @DisplayName("우승자가 여러명일 때 우승자를 구할 수 있다")
    @Test
    void testFindWinner() {
        // given
        Cars cars = new Cars(List.of("a", "b", "c"));
        Movable movable = new FixedMovable(true);
        cars.moveAllCars(movable);

        // when
        WinnerDto winnerDto = cars.findWinner();

        // then
        assertThat(winnerDto.winners().get(0).getName()).isEqualTo("a");
        assertThat(winnerDto.winners().get(1).getName()).isEqualTo("b");
        assertThat(winnerDto.winners().get(2).getName()).isEqualTo("c");
    }

    @DisplayName("toCarsDto를 통해 Cars를 Dto로 변환할 수 있음")
    @Test
    void testToCarsDto() {
        // given
        Cars cars = new Cars(List.of("a", "b", "c"));

        // when
        CarsDto carsDto = cars.toCarsDto();

        // then
        assertThat(carsDto.cars().size()).isEqualTo(3);

        assertThat(carsDto.cars().get(0).carName()).isEqualTo("a");
        assertThat(carsDto.cars().get(0).position()).isEqualTo(0);

        assertThat(carsDto.cars().get(1).carName()).isEqualTo("b");
        assertThat(carsDto.cars().get(1).position()).isEqualTo(0);

        assertThat(carsDto.cars().get(2).carName()).isEqualTo("c");
        assertThat(carsDto.cars().get(2).position()).isEqualTo(0);
    }
}