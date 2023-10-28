package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 자동차 전진")
    void givenNumber_whenMove_thenIncreasePosition() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 자동차 멈춤")
    void givenNumber_whenMove_thenStop() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(3);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
