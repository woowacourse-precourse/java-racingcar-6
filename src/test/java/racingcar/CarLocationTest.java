package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarLocationTest {


    private CarLocation carLocation = new CarLocation();

    @Test
    @DisplayName("차의 위치가 움직이거나 정지했는지 확인")
    void carLocate() {
        // given
        List<Car> carList = new ArrayList<>();
        Car car = new Car("pobi", 0);
        carList.add(car);


        // when
        carLocation.carLocate(carList);

        // then
        assertTrue(car.getLocate().equals(0) || car.getLocate().equals(1));
    }
}