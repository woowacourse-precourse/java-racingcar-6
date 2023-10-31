package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @DisplayName("5글자 이내라면 객체생성을 성공한다..")
    void givenWithin5Chars_whenCreateCar_thenSuccess() {
        // given
        String name = "yoon";
        // when
        Car car = Car.of(name);
        // then
        assertThat(car.name()).isEqualTo(name);
    }

    @Test
    @DisplayName("5를 초과하면 예외를 객체 생성시 발생시킨다.")
    void givenMore5Chars_whenCreateCar_thenFail() {
        // given
        String name = "yoonjaeyong";
        // when & then
        assertThatThrownBy(() -> Car.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
    @Test
    @DisplayName("move()의 결과로 1 또는 0이 오는지 확인한다.")
    void givenMove_whenMove_thenSuccess() {
        // given
        Car car = Car.of("yoons");
        // when
        int result = car.move();
        // then
        assertThat(result).isIn(0, 1);
    }
}
