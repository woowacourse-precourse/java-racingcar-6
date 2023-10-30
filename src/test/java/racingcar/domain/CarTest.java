package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("move를 하면 car의 position이 증가한다")
    @Test
    void test() {
        // given
        Car carA = Car.of("carA");

        // when
        carA.move();

        // then
        assertThat(carA.getPosition()).isEqualTo(1);
    }
}