package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car1;

    @BeforeEach
    void init() {
        car1 = new Car("ccc");
    }

    @Test
    void forward() {
        car1.forward();
        assertThat(car1.currentLocation()).isEqualTo(1);
    }

    @Test
    void currentLocation() {
        car1.forward();
        car1.forward();
        car1.forward();
        assertThat(car1.currentLocation()).isEqualTo(3);
    }

    @Test
    public void testValidCarName() {
        String validName = "Car1";
        Car car = new Car(validName);
        String carName = car.myCarName();
        assertThat(validName).isEqualTo(carName);
    }

    @Test
    void testInvalidCarName() {
        String invalidName = "ThisIsTooLong";
        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}