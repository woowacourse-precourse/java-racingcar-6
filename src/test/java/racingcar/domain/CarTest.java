package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void testCarName() {
        String testName = "name";
        Car car = new Car(testName);
        assertThat(car.getName()).isEqualTo(testName);
    }

    @Test
    public void testInitialPosition() {
        String testName = "name";
        Car car = new Car(testName);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    public void testMoveCar() {
        String testName = "name";
        Car car = new Car(testName);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
