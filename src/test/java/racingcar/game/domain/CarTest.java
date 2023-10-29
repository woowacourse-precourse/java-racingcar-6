package racingcar.game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차_생성() {
        Car car = Car.create("hwang");
        assertThat(car).isNotNull();
    }

    @Test
    void 이름이_6자_이상이면_자동차_생성X() {
        assertThatThrownBy(() -> Car.create("avante"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 5자 이하가 아닙니다.");

    }

    @Test
    void 자동차_전진_시도_후_상태_체크() {
        Car car = Car.create("hwang");

        for (int i = 0; i < 5; i++) {
            car.tryForward();
        }

        StringBuilder forwardState = car.getForwardState();
        assertThat(car.getCarState()).isEqualTo("hwang : " + forwardState);
    }

}