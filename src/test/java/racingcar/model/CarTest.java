package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


    @DisplayName("자동차 이름이 정상적으로 생성되고, 불러오는지 확인")
    @Test
    void getName() {
        // given
        final String name = "자동차";

        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름이 빈 상태로 생성할 때 예외를 반환하는지 확인")
    @Test
    void getNameThrowCase1() {
        // given
        final String name = "";

        // when, then
        assertThatThrownBy(() -> new Car(name), "이름 값이 비어있음.")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 값이 없습니다.");
    }

    @DisplayName("자동차 이름이 너무 긴 상태로 생성할 때 예외를 반환하는지 확인")
    @Test
    void getNameThrowCase2() {
        // given
        final String name = "123456";

        // when, then
        assertThatThrownBy(() -> new Car(name), "이름의 값이 5를 넘음")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 5보다 큽니다.");
    }

    @DisplayName("전진 횟수가 증가하는지, 전진 횟수를 확인")
    @Test
    void increaseAdvance_and_getAdvance() {
        // given
        final String name = "test";
        final Car car = new Car(name);

        // when
        car.increaseAdvance();
        int advance = car.getAdvance();

        // then
        assertThat(advance).isEqualTo(1);
    }
}