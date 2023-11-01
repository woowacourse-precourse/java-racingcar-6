package racingcar.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class CarDriveTest {
    @Test
    public void testDrive() {
        Car car = new Car("TestCar");

        car.drive();
        car.drive();
        car.drive();

        int currentPosition = car.getPosition();
        String showCurrentPosition = car.showCarPosition();

        assertThat(currentPosition).isEqualTo(showCurrentPosition.length());
    }
}
