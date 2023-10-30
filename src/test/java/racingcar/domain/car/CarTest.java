package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {
    @Test
    @DisplayName("자동차의 이름이 5글자를 초과할 경우 IllegalArgumentException 예외 발생")
    void createCar_WithLongName_ExceptionThrown() {
        // given
        String name = "yookyungmi";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이여야 함")
    void createCar_WithValidName_InitialPositionIsZero() {
        // given
        String name = "yooo";

        // when
        Car car = new Car(name);

        // then
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("move 메서드 호출 시 자동차의 위치가 1 증가해야 함")
    void move_IncrementCarPositionByOne()  {
        // given
        Car car = new Car("yooo");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
