package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름_전달() {
        String name = "star";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 전진_거리_증가_시키기() {
        String name = "star";
        int move = 5;
        Car car = new Car(name);
        car.updateDistance(move);
        assertThat(car.getDistance()).isEqualTo(move);

    }

    @Test
    void 전진_거리_전달() {
        String name = "star";
        Car car = new Car(name);
        assertThat(car.getDistance()).isZero();
    }
}
