package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void Car_생성자_테스트() {
        String name = "red";

        Car car = new Car(name);

        assertEquals(name, car.getName());
        assertEquals(0, car.getPosition());
    }
}
