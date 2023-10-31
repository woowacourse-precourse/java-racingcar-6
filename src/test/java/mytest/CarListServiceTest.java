package mytest;

import org.junit.jupiter.api.Test;
import service.CarListService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarListServiceTest {
    @Test
    void StringtoMap_테스트() {
        //given
        CarListService carListServiceTest = new CarListService();
        String carListName = "a,b,c";
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("a", 0);
        expectedMap.put("b", 0);
        expectedMap.put("c", 0);

        //when
        carListServiceTest.init(carListName);

        //then
        assertEquals(expectedMap, carListServiceTest.getCarList());
    }

    @Test
    void forwardCar_테스트() {
        //given
        CarListService carListServiceTest = new CarListService();
        String carListName = "a,b,c";
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("a", 1);
        expectedMap.put("b", 1);
        expectedMap.put("c", 0);

        //when
        carListServiceTest.init(carListName);
        carListServiceTest.forwardCar("a");
        carListServiceTest.forwardCar("b");

        //then
        assertEquals(expectedMap, carListServiceTest.getCarList());
    }

}
