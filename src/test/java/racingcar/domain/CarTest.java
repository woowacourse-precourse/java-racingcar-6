package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

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
    void moveForward_Success() {
        // given
        Car car = new Car("pobi");

        // when
        int forwardCount = car.moveForward(5);

        // then
        Assertions.assertThat(forwardCount).isEqualTo(1);
    }

    @DisplayName("새로 생성된 자동차가 전진에 실패하면, 그 자동차의 전진 횟수는 0이다.")
    @Test
    void moveForward_Fail_ByValueIsLessThanSpecifiedNumber() {
        // given
        Car car = new Car("pobi");

        // when
        int forwardCount = car.moveForward(3);

        // then
        Assertions.assertThat(forwardCount).isEqualTo(0);
    }

    @DisplayName("자동차의 전진 횟수 0과 5를 비교해서 더 큰 전진 횟수를 반환한 결과는 5다.")
    @Test
    void getLargerForwardCount_ReturnLargerForwardCount() {
        // given
        Car car = new Car("pobi");

        // when
        int largerForwardCount = car.getLargerForwardCount(5);

        // then
        Assertions.assertThat(largerForwardCount).isEqualTo(5);
    }

    @DisplayName("자동차의 전진 횟수와 파라미터로 받은 전진 횟수가 같으면 true를 반환한다.")
    @Test
    void isForwardCountSameAs_True() {
        // given
        Car car = new Car("pobi");
        car.moveForward(5);

        // when, then
        Assertions.assertThat(car.isForwardCountSameAs(1)).isTrue();
    }
}