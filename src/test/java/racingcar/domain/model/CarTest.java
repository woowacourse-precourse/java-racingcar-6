package racingcar.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 자동차_객체를_생성한다() {
        // given
        String carsName = "joy,happy";

        // when
        Car car = Car.of(carsName);

        // then
        assertThat(car.getNames()).contains("joy", "happy");
        assertThat(car.getNames()).containsExactly("joy", "happy");
    }
}