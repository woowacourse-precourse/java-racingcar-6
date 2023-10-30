package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @DisplayName("랜덤 숫자가 4 이상인 경우 자동차가 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carMoveTest(int randomNumber) {
        // given
        Car pobi = Car.makeCar("pobi");

        // when
        pobi.tryMove(randomNumber);

        // then
        assertThat(pobi.getPosition()).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @DisplayName("랜덤 숫자가 3 이하인 경우 자동차가 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void carDoNotMoveTest(int randomNumber) {
        // given
        Car pobi = Car.makeCar("pobi");

        // when
        pobi.tryMove(randomNumber);

        // then
        assertThat(pobi.getPosition()).isEqualTo(new Position(0));
    }
}
