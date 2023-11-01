package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.boxed.CarName;
import racingcar.domain.coordinate.boxed.Coordinate;

final class CarFinishedTest {

    @DisplayName("CarName과 Coordinate를 인자로 전달하여 CarFinished를 생성할 수 있다.")
    @Test
    void CarFinished_withCarNameAndCoordinate_shouldCreateCarFinished() {
        // given
        final CarName carName = new CarName("a");
        final Coordinate coordinate = Coordinate.zero();

        // when
        final CarFinished carFinished = new CarFinished(carName, coordinate);

        // then
        assertThat(carFinished.carName).isEqualTo(carName);
        assertThat(carFinished.coordinate).isEqualTo(coordinate);
    }

    @DisplayName("CarRacing을 CarFinished로부터 생성할 수 있다.")
    @Test
    void toFinished_fromCarRacing_shouldCreateCarFinished() {
        // given
        final String carName = "a";
        final CarRacing carRacing = new CarRacing(carName);

        // when
        final CarFinished carFinished = carRacing.toFinished();

        // then
        assertThat(carFinished.carName.carName()).isEqualTo(carName);
        assertThat(carFinished.coordinate).isEqualTo(Coordinate.zero());
    }

    @DisplayName("서로 다른 CarFinished를 비교하면 Coordinate에 따라 결과가 결정된다")
    @Test
    void compareTo_ofCarFinished_shouldResultByCoordinate() {
        // given
        final CarName carName1 = new CarName("a");
        final Coordinate coordinate1 = new Coordinate(2);
        final CarName carName2 = new CarName("b");
        final Coordinate coordinate2 = new Coordinate(1);
        final CarName carName3 = new CarName("c");
        final Coordinate coordinate3 = new Coordinate(1);

        final CarFinished carFinished1 = new CarFinished(carName1, coordinate1);
        final CarFinished carFinished2 = new CarFinished(carName2, coordinate2);
        final CarFinished carFinished3 = new CarFinished(carName3, coordinate3);

        // when
        final int result1 = carFinished1.compareTo(carFinished2);
        final int result2 = carFinished2.compareTo(carFinished1);
        final int result3 = carFinished2.compareTo(carFinished3);

        // then
        assertThat(result1).isPositive();
        assertThat(result2).isNegative();
        assertThat(result3).isZero();
    }
}