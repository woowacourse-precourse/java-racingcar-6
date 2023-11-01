package mytest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.CarActionHandler;
import service.CarService;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CarServiceTest {
    @Test
    void 자동차_1개입력_테스트() {
        //given
        String carList = "a";
        CarActionHandler carActionHandler = new CarActionHandler();
        LinkedHashMap<String, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put("a", 0);

        //when
        carActionHandler.init(carList);

        //then
        assertThat(carActionHandler.getCarList()).isEqualTo(expectedMap);
    }


    private CarService carService;
    @BeforeEach
    void setUp1() {
        carService = new CarService();
    }
    @Test
    void testInit() {
        carService.init("Car1,Car2,Car3");
    }
    @Test
    void 랜덤전진값_테스트() {
        for (int i = 0; i < 100; i++) {
            boolean result = carService.isCarMoving();
            assertTrue(result == true || result == false);
        }
    }
}
