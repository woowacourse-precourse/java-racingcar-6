package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.RandomUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void getNameTest() {
        CarName carName = new CarName("Car");
        Car car = new Car(carName);

        assertEquals("Car", car.getName());
    }

    @Test
    void moveTest1() {
        Car car = new Car(new CarName("Car"));
        int initialPosition = car.getPosition();

        car.move(1);

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    void moveTest2() {
        CarName carName = new CarName("Car");
        Car car = new Car(carName);

        int initialPosition = car.getPosition();
        car.move(0); // Assuming isMove(0) returns false

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    void getPositionTest() {
        CarName carName = new CarName("Car");
        Car car = new Car(carName);

        assertEquals(0, car.getPosition());
    }
}
