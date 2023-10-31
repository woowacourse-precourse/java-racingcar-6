package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("pobi");
    }

    @Test
    public void getName_Test() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    public void getPosition_Test() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void move_Test() {
        car.move();
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }
}
