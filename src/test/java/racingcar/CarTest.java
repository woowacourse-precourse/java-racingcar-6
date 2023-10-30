package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import game.car.CarName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void CarName_이름이_5자초과인_경우_예외_발생() {
        assertThatThrownBy(() -> new CarName("dubibu"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하여야 합니다.");
    }

    @Test
    void CarName_이름이_5자이하인_경우_객체_생성() {
        CarName carName = new CarName("dubib");

        assertThat(carName).hasFieldOrPropertyWithValue("carName","dubib");
    }

}
