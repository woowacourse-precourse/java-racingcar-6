package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("정상적인 이름으로 Car 객체 생성할 수 있다.")
    @Test
    void carConstruct() {
        //given
        String name = "cjy";
        //when
        Car car = Car.of(name);
        //then
        assertThat(car).isNotNull();
    }

    @DisplayName("이름이 5자를 초과하면 IllegalArgumentException이 발생한다.")
    @Test
    void carConstructException() {
        //given
        String name = "junyoung";
        //when
        //then
        assertThatThrownBy(() -> Car.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("4이상의 숫자가 주어지면 전진한다.")
    @Test
    void carForward() {
        //given
        int number = 4;
        Car car = Car.of("cjy");
        //when
        car.race(number);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("4미만의 숫자가 주어지면 전진하지 않는다.")
    @Test
    void carStop() {
        //given
        int number = 3;
        Car car = Car.of("cjy");
        //when
        car.race(number);
        //then
        assertThat(car.getPosition()).isZero();
    }

}