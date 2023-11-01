package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void moveForwardTest() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);

        car.Move(4); //차량을 전진한다.
        assertThat(car.getPosition()).isEqualTo(1);

        car.Move(3);  //차량을 전진시키지 않는다.
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void getNameTest() {
        String testName = "test";
        Car car = new Car(testName);

        assertThat(car.getName()).isEqualTo(testName);
    }
}