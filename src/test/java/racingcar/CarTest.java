package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    Car car = new Car("car");

    @Test
    public void Car_생성자_이름_설정() {
        assertEquals("car", car.getName());
    }

    @Test
    public void Car_전진값_설정() {
        car.setForwardValue(5);
        assertEquals(5, car.getForwardValue());
    }

    @Test
    public void Car_총_전진값_확인() {
        assertEquals(0, car.getTotalForward());

        car.setForwardValue(4);
        car.addTotalForward();
        assertEquals(4, car.getTotalForward());
    }

}
