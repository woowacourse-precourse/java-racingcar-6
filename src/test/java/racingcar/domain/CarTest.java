package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 제대로 설정되는지 테스트")
    void testGetName() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("자동차의 초기 위치가 0인지 테스트")
    void testInitialPosition() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
