package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;

@DisplayName("자동차 기능 테스트")
public class CarTest {
    @DisplayName("4 이상의 숫자가 들어오면 전진")
    @Test
    void move_forward_when_number_4_up () {
        // given
        Car car = new Car();

        // when
        Boolean result = car.checkForward(4);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("3 이하의 숫자가 들어오면 아무 동작도 하지 않음")
    @Test
    void stop_when_number_3_down () {
        // given
        Car car = new Car();

        // when
        Boolean result = car.checkForward(3);

        // then
        assertThat(result).isFalse();
    }
}
