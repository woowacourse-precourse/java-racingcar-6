package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarData;

public class CarDataTest {

    @Test
    public void 차_이름_생성_테스트() {
        Car car = new Car("test", 0);
        CarData carData = car.getData();
        assertEquals("test", carData.getName());
    }

    @Test
    public void 차_이동거리_생성_테스트() {
        Car car = new Car("test", 0);
        CarData carData = car.getData();
        assertEquals(0, carData.getMoveDistance());
    }


}