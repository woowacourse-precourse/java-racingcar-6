package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    @DisplayName("자동차의 현재 이동거리 비교")
    void testCompareCarDistance() {
        Car car1 = new Car("car1", 4);
        Car car2 = new Car("car2", 5);

        Assertions.assertThat(car1.compareTo(car2)).isEqualTo(-1);
        Assertions.assertThat(car2.compareTo(car2)).isEqualTo(0);
        Assertions.assertThat(car1.hasSameDistance(car2)).isEqualTo(false);
    }

    @Test
    @DisplayName("자동차의 현재 이동거리를 표시")
    void testShowCarDistance() {
        Car car1 = new Car("car1", 4);
        Car car2 = new Car("car2", 5);

        Assertions.assertThat(car1.showDistance()).isEqualTo("----");
        Assertions.assertThat(car2.showDistance()).isEqualTo("-----");
    }

    @Test
    @DisplayName("자동차 이동 성공 테스트")
    void testMoveSuccess() {
        Car car1 = new Car("car1", 0, (min, max) -> 4);

        car1.move();

        Assertions.assertThat(car1).extracting("moveDistance").isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 실패 테스트")
    void testMoveFailed() {
        Car car1 = new Car("car1", 0, (min, max) -> 3);

        car1.move();

        Assertions.assertThat(car1).extracting("moveDistance").isEqualTo(0);
    }
}