package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    private final Car car = new Car("pobi");

    @Test
    void 이름_얻기() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 위치_얻기() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 위치_1회_전진() {
        car.movePosition();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}