package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static final int INITIAL_POSITION = 0;

    @Test
    @DisplayName("생성된 이름과 위치 확인")
    public void 자동차_모델_생성() {
        // given
        Car car = new Car("son");

        // when
        String carName = car.getName();
        int position = car.getPosition();

        // then
        assertAll(
                () -> assertThat(carName).isEqualTo("son"),
                () -> assertThat(position).isEqualTo(INITIAL_POSITION)
        );
    }
}