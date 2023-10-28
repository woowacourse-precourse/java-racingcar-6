package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int INITIAL_POSITION = 0;

    @Test
    @DisplayName("자동차의 처음 위치가 0임을 검증")
    void initialCarPositionIsZeroTest() {
        //given
        Car car = new Car("자동차");

        //when
        int position = car.getCarPosition();

        //then
        assertThat(position).isEqualTo(INITIAL_POSITION);
    }
}
