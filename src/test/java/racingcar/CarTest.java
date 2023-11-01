package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car("subin");

    @Test
    @DisplayName("4이상일 때 전진")
    void 전진_확인() {
        car.decideGo(6);
        assertThat(car.changeDistanceToInt()).isEqualTo(1);
    }

}