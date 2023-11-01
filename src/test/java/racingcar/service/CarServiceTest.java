package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarServiceTest {

    @Test
    @DisplayName("List에 담긴 차 이름들로 차 객체가 담긴 List가 생성된다.")
    void testRegisterCarList() {
        CarService carService = new CarService();

        List<String> carNameList = Arrays.asList("Car1", "Car2", "Car3");
        List<Car> carList = carService.registerCarList(carNameList);

        assertEquals(3, carList.size());
        assertEquals("Car1", carList.get(0).getName());
        assertEquals("Car2", carList.get(1).getName());
        assertEquals("Car3", carList.get(2).getName());
    }


}
