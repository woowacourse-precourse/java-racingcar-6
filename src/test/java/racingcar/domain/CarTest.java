package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 4 이상인 경우 자동차가 움직인다.")
    void carMoveTest() {
        // given
        Car pobi = Car.makeCar("pobi");
        int randomNumber = 4;

        // when
        pobi.tryMove(randomNumber);

        // then
        assertThat(pobi.getPosition()).isEqualTo("-");
    }

    @Test
    @DisplayName("랜덤 숫자가 3 이하인 경우 자동차가 움직이지 않는다.")
    void carDoNotMoveTest() {
        // given
        Car pobi = Car.makeCar("pobi");
        int randomNumber = 3;

        // when
        pobi.tryMove(randomNumber);

        // then
        assertThat(pobi.getPosition()).isEqualTo("");
    }
}
