package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("10만큼 전진한 경우의 표시")
    @Test
    void 전진_상황_표시_거리10() {
        Car car = new Car("oh");
        car.distanceMoved = 10;
        String result = car.visualizeDistanceAsString();
        assertThat(result).isEqualTo("----------");
    }

    @DisplayName("전진하지 못한 경우의 표시")
    @Test
    void 전진_상황_표시_거리0() {
        Car car = new Car("oh");
        car.distanceMoved = 0;
        String result = car.visualizeDistanceAsString();
        assertThat(result).isEqualTo("");
    }
}