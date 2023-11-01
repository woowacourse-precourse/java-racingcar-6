package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_이름_길이초과_예외() {
        //given
        final Car car = new Car("woowa");

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> car.setName("overfive"));

        // then
        Assertions.assertThat(exception.getMessage()).isEqualTo("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_공백() {
        // given
        final Car car = new Car("woowa");

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> car.setName(""));

        // then
        Assertions.assertThat(exception.getMessage()).isEqualTo("이름에 공백이 포함되었습니다.");
    }

    @Test
    void 자동차_이름_공백포함() {
        // given
        final Car car = new Car("woowa");

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> car.setName("c ar"));

        // then
        Assertions.assertThat(exception.getMessage()).isEqualTo("이름에 공백이 포함되었습니다.");
    }

    @Test
    void 자동차객체_현재상태() {
        // given
        final Car car = new Car("woowa");

        // when
        final int initState = car.getState();
        car.move();

        // then
        Assertions.assertThat(car.getName()).isEqualTo("woowa");
        Assertions.assertThat(initState).isEqualTo(0);
        Assertions.assertThat(car.getState()).isEqualTo(1);
        Assertions.assertThat(car.currentStatus()).isEqualTo("woowa : -");
    }
}