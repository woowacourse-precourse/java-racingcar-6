package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void eqauls_메소드_테스트() {
        Car car1 = new Car(new Name("MyCar"));
        Car car2 = new Car(new Name("MyCar"));
        assertEquals(car1, car2);
    }
}
