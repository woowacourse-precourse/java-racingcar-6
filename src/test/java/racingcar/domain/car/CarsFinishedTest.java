package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.domain.car.testutil.CarsTestUtils.createCarFinished;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.output.WinnersDto;
import racingcar.domain.coordinate.boxed.Coordinate;
import racingcar.domain.move.MoveCommand;

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

    @DisplayName("CarRacing의 상태를 그대로 유지한 채 CarFinished로 변환 가능")
    @Test
    void Car() {
        // given
        final CarRacing carRacing1 = new CarRacing("a");
        final CarRacing carRacing2 = new CarRacing("b");
        final CarRacing carRacing3 = new CarRacing("c");
        final CarsRacing carsRacing = CarsRacing.from(List.of(carRacing1, carRacing2, carRacing3));

        // when
        final CarsFinished carsFinished = carsRacing.toFinished();

        // then
        assertThat(carsFinished.cars.get(0).carName).isEqualTo(carRacing1.carName);
        assertThat(carsFinished.cars.get(0).coordinate).isEqualTo(carRacing1.coordinate);

        assertThat(carsFinished.cars.get(1).carName).isEqualTo(carRacing2.carName);
        assertThat(carsFinished.cars.get(1).coordinate).isEqualTo(carRacing2.coordinate);

        assertThat(carsFinished.cars.get(2).carName).isEqualTo(carRacing3.carName);
        assertThat(carsFinished.cars.get(2).coordinate).isEqualTo(carRacing3.coordinate);
    }

    @DisplayName("CarsFinished를 WinnersDto로 변환하여 우승자 이름 조회 가능")
    @Test
    void toWinnersDto_fromCarsFinished_shouldReturnWinnersDtoContainsSingleWinnerName() {
        // given
        final CarRacing carRacing1 = new CarRacing("a");
        final CarRacing carRacing2 = new CarRacing("b");
        final CarRacing carRacing3 = new CarRacing("c");

        carRacing1.moveBy(MoveCommand.GO);
        carRacing1.moveBy(MoveCommand.GO);

        carRacing2.moveBy(MoveCommand.GO);

        final CarsRacing carsRacing = CarsRacing.from(List.of(carRacing1, carRacing2, carRacing3));

        // when
        final WinnersDto winnersDto = carsRacing.toFinished().toWinnersDto();

        // then
        assertThat(winnersDto.winners().size()).isEqualTo(1); // 우승자 1명 "a"

        assertThat(winnersDto.winners().get(0).carName()).isEqualTo("a");
    }

    @DisplayName("CarsFinished를 WinnersDto로 변환하여 모든 우승자 이름 조회 가능")
    @Test
    void toWinnersDto_fromCarsFinished_shouldReturnWinnersDtoContainsManyWinnerNames() {
        // given
        final CarRacing carRacing1 = new CarRacing("a");
        final CarRacing carRacing2 = new CarRacing("b");
        final CarRacing carRacing3 = new CarRacing("c");

        carRacing1.moveBy(MoveCommand.GO);
        carRacing2.moveBy(MoveCommand.GO);

        final CarsRacing carsRacing = CarsRacing.from(List.of(carRacing1, carRacing2, carRacing3));

        // when
        final WinnersDto winnersDto = carsRacing.toFinished().toWinnersDto();

        // then
        assertThat(winnersDto.winners().size()).isEqualTo(2); // 우승자 2명 "a", "b"

        assertThat(winnersDto.winners().get(0).carName()).isEqualTo("a");
        assertThat(winnersDto.winners().get(1).carName()).isEqualTo("b");
    }
}