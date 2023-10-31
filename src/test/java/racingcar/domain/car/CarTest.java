package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.util.RandomMoveStrategy.MIN_NUM;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {
    @Test
    @DisplayName("자동차의 이름이 5글자를 초과할 경우 IllegalArgumentException 예외 발생")
    void createCar_WithLongName_ExceptionThrown() {
        // given
        String name = "yookyungmi";

        // when & then
        assertThatThrownBy(() -> new Car(name, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이여야 함")
    void createCar_WithValidName_InitialPositionIsZero() {
        // given
        String name = "yooo";

        // when
        Car car = new Car(name, () -> true);

        // then
        assertThat(car.getPosition()).isZero();
    }


    @Test
    @DisplayName("0에서 9 사이의 무작위 값이 4 이상일 경우 자동차가 전진한다.")
    void move_RandomNumberGreaterThanOrEqualFour_CarMoves() {
        // Given
        Car car = new Car("car", () -> 5 >= MIN_NUM);

        // When
        car.move();

        // Then
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("0에서 9 사이의 무작위 값이 4 미만일 경우 자동차가 전진하지 않는다.")
    void move_RandomNumberLessThanFour_CarDoesNotMove() {
        // Given
        Car car = new Car("car", () -> 3 >= MIN_NUM);

        // When
        car.move();

        // Then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
