package racingcar;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void Car_세팅_테스트() {
        Car car = new Car("testCar");
        assertEquals("", car.getStat());
    }

    @Test
    public void UpdateStat_메서드_확인_테스트() {
        Car car = new Car("testCar");
        car.updateStat();
        assertEquals("-", car.getStat());
    }
}
