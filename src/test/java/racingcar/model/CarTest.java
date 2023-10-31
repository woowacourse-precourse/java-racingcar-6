package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("test");
    }

    @Test
    void 초기화시_위치가_0() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
