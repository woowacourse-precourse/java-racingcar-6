package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("한 칸 전진한 차와 그대로인 차의 거리는 다름")
    @Test
    void forwardDiffDistance_false() {

        Car carA = new Car("carA");
        Car carB = new Car("carB");
        carA.forward();

        Assertions.assertThat(carA.isSameDistance(carB)).isFalse();
    }
    @DisplayName("같은 수 전진하면 차의 거리는 같음")
    @Test
    void forwardSameDistance_true() {

        Car carA = new Car("carA");
        Car carB = new Car("carB");
        carA.forward();
        carB.forward();

        Assertions.assertThat(carA.isSameDistance(carB)).isTrue();
    }

    @DisplayName("전진을 더 많이 한 차가 더 큰 distance 가짐")
    @Test
    void moreForwardCarIsMaxCar() {

        Car carA = new Car("carA");
        Car carB = new Car("carB");
        carA.forward();
        carA.forward();
        carB.forward();

        Assertions.assertThat(carA.maxDistanceCar(carB)).isEqualTo(carA);
    }
}