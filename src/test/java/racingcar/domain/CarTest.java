package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Test");
    }
    @Test
    void Car의_이름_반환() {
        assertThat(car.getName()).isEqualTo("Test");
    }
}
