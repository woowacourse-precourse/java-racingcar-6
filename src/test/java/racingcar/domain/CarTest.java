package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    void 자동차_거리비교_테스트() {
        Car car1 = new Car("car1", 4, (min, max) -> max);
        Car car2 = new Car("car2", 5, (min, max) -> max);

        Assertions.assertThat(car1.compareTo(car2)).isEqualTo(-1);
        Assertions.assertThat(car2.compareTo(car2)).isEqualTo(0);
        Assertions.assertThat(car1.hasSameDistance(car2)).isEqualTo(false);
    }

    @Test
    void 자동차_현재_이동거리_보여주기_테스트() {
        Car car1 = new Car("car1", 4, (min, max) -> max);
        Car car2 = new Car("car2", 5, (min, max) -> max);

        Assertions.assertThat(car1.showDistance()).isEqualTo("----");
        Assertions.assertThat(car2.showDistance()).isEqualTo("-----");
    }

    @Test
    void 자동차_이동성공_테스트() {
        Car car1 = new Car("car1", 0, (min, max) -> 4);

        car1.move();

        Assertions.assertThat(car1).extracting("moveDistance").isEqualTo(1);
    }

    @Test
    void 자동차_이동실패_테스트() {
        Car car1 = new Car("car1", 0, (min, max) -> 3);

        car1.move();

        Assertions.assertThat(car1).extracting("moveDistance").isEqualTo(0);
    }
}