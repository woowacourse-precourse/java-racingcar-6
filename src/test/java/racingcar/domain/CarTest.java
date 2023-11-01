package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("move를 하면 car의 position이 증가한다")
    @Test
    void testMove() {
        // given
        Car carA = Car.of("carA");

        // when
        carA.move();

        // then
        assertThat(carA.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 움직였을 때 포지션을 얻을 수 있다")
    @Test
    void testGetPosition1() {
        // given
        Car carA = Car.of("carA");
        carA.move();

        // when
        int position = carA.getPosition();

        // then
        assertThat(position).isEqualTo(1);
    }

    @DisplayName("자동차가 움직이지 않았을 때 포지션을 얻을 수 있다")
    @Test
    void testGetPosition2() {
        // given
        Car carA = Car.of("carA");

        // when
        int position = carA.getPosition();

        // then
        assertThat(position).isEqualTo(0);
    }

    @DisplayName("자동차의 이름을 얻을 수 있다")
    @Test
    void testGetName() {
        // given
        Car carA = Car.of("carA");

        // when
        String name = carA.getName();

        // then
        assertThat(name).isEqualTo("carA");
    }
}