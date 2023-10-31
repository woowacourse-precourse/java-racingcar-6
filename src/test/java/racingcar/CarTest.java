package racingcar;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    @Test
    void 차_이동_테스트() {
        Car car = new Car("Car");
        car.carMove(5);
        assertEquals(1, car.getPosition());
    }

    @Test
    void 차_이동_하지않는경우_테스트() {
        Car car = new Car("Car");
        car.carMove(2);
        assertEquals(0, car.getPosition()); // 4 미만의 값이므로 위치 이동 X
    }
}
