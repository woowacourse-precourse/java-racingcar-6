package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.boxed.CarName;
import racingcar.domain.car.dto.output.WinnersDto;
import racingcar.domain.coordinate.boxed.Coordinate;

final class CarsFinishedTest {

    @DisplayName("CarsFinished 생성자로 CarName, Coordinate를 주입하여 객체 생성 가능")
    @Test
    void CarsFinished_withCarNameAndCoordinate_shouldCreateInstance() {
        // given
        final List<CarFinished> carFinishedList = List.of(
                createCarFinished("a"),
                createCarFinished("b"),
                createCarFinished("c")
        );

        // when
        final CarsFinished carsFinished = new CarsFinished(carFinishedList);
        final List<? extends Car> cars = carsFinished.cars;

        // then
        assertThat(cars.size()).isEqualTo(3);

        assertThat(cars.get(0).carName.carName()).isEqualTo("a");
        assertThat(cars.get(0).coordinate).isEqualTo(Coordinate.zero());

        assertThat(cars.get(1).carName.carName()).isEqualTo("b");
        assertThat(cars.get(1).coordinate).isEqualTo(Coordinate.zero());

        assertThat(cars.get(2).carName.carName()).isEqualTo("c");
        assertThat(cars.get(2).coordinate).isEqualTo(Coordinate.zero());
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        final CarFinished carFinished1 = createCarFinished("a");
        final CarFinished carFinished2 = createCarFinished("b");
        final CarFinished carFinished3 = createCarFinished("c");

        final List<CarFinished> carFinishedList = List.of(
                carFinished1,
                carFinished2,
                carFinished3
        );
        final CarsFinished carsFinished = new CarsFinished(carFinishedList);

        // when
        final WinnersDto winnersDto = carsFinished.toWinnersDto();

        // then
    }

    private CarFinished createCarFinished(final String carName) {
        return new CarFinished(new CarName(carName), Coordinate.zero());
    }
}