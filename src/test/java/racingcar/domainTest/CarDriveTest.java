package racingcar.domainTest;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarDriveTest {
    @Test
    public void testDrive() {
        Car car = new Car("TestCar");

        // Simulate a few drives
        car.drive();
        car.drive();
        car.drive();

        int currentPosition = car.getPosition();
        String showCurrentPosition = car.showCarPosition();

        assertThat(currentPosition).isEqualTo(showCurrentPosition.length());
    }
}
