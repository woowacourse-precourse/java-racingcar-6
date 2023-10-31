package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void equals_메소드_테스트() {
        Car car1 = Car.withName(new Name("MyCar"));
        Car car2 = Car.withName(new Name("MyCar"));
        assertEquals(car1, car2);
    }
}
