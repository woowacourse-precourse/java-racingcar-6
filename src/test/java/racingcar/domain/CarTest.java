package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    @DisplayName("자동차의 초기위치는 0")
    void 초기_위치_0() {
        // given
        String name = "1234";

        // when
        Car car = Car.from(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름 길이는 5이하만 가능")
    void 이름길이_5초과_예외() {

        String name = "123456";

        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈문자는 생성 불가능")
    void 빈문자_예외() {

        String name = " ";

        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 4이상일 떄 이동")
    void 숫자_4이상만_이동() {
        // given
        Integer number = 4;
        Car car = Car.from("1234");

        // when
        car.go(number);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
        car.isHere(1);
    }

    @Test
    @DisplayName("숫자 4미만 이동불가")
    void 숫자_4_미만_이동불가() {
        // given
        Integer number = 3;
        Car car = Car.from("1234");

        // when
        car.go(number);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
        car.isHere(0);
    }


}