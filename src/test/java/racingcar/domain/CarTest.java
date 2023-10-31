package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final int VALUE_FOR_MOVING_FORWARD = 5;
    private static final int VALUE_FOR_STOP = 2;

    @DisplayName("자동차 생성 시 이름 글자수가 최솟값보다 작으면 예외가 발생한다.")
    @Test
    void constructCar_Fail_ByNameLengthIsLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 생성 시 이름 글자수가 최댓값보다 크면 예외가 발생한다.")
    @Test
    void constructCar_Fail_ByNameLengthIsLessThanMaximum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new Car("elephant"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("새로 생성된 자동차가 전진에 성공하면, 그 자동차의 전진 횟수는 1이다.")
    @Test
    void move_Success() {
        // given
        Car car = createCar();

        // when
        int forwardCount = car.move(VALUE_FOR_MOVING_FORWARD);

        // then
        Assertions.assertThat(forwardCount).isEqualTo(1);
    }

    @DisplayName("새로 생성된 자동차가 전진에 실패하면, 그 자동차의 전진 횟수는 0이다.")
    @Test
    void move_Fail_ByValueIsLessThanSpecifiedNumber() {
        // given
        Car car = createCar();

        // when
        int forwardCount = car.move(VALUE_FOR_STOP);

        // then
        Assertions.assertThat(forwardCount).isEqualTo(0);
    }

    @DisplayName("자동차의 전진 횟수와 파라미터로 받은 전진 횟수가 같으면 true를 반환한다.")
    @Test
    void isForwardCountSameAs_True() {
        // given
        Car car = createCar();
        car.move(VALUE_FOR_MOVING_FORWARD);

        // when, then
        Assertions.assertThat(car.isForwardCountSameAs(1)).isTrue();
    }

    private Car createCar() {
        return new Car("pobi");
    }
}
