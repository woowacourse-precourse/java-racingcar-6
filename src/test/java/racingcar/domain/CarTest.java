package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {
    @Test
    void 자동차_객체를_생성한다() {
        Car car = new Car("Jason");
        assertThat(car.getName()).isEqualTo("Jason");
    }

    @Test
    public void testInitialPosition() {
        Car car = new Car("TestCar");
        assertEquals(0, car.getPosition());
    }

    @Test
    public void testMove() {
        Car car = new Car("TestCar");
        int initialPosition = car.getPosition();
        car.move();
        if (car.getPosition() > initialPosition) {
            assertEquals(1, car.getPosition() - initialPosition);
        } else {
            assertEquals(initialPosition, car.getPosition());
        }
    }
}