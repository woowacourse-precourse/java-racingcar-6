package mytest;

import org.junit.jupiter.api.Test;
import service.CarActionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarActionHandlerTest {
    @Test
    void StringtoMap_테스트() {
        //given
        CarActionHandler carActionHandlerTest = new CarActionHandler();
        String carListName = "a,b,c";
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("a", 0);
        expectedMap.put("b", 0);
        expectedMap.put("c", 0);

        //when
        carActionHandlerTest.init(carListName);

        //then
        assertEquals(expectedMap, carActionHandlerTest.getCarList());
    }

    @Test
    void forwardCar_테스트() {
        //given
        CarActionHandler carActionHandlerTest = new CarActionHandler();
        String carListName = "a,b,c";
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("a", 1);
        expectedMap.put("b", 1);
        expectedMap.put("c", 0);

        //when
        carActionHandlerTest.init(carListName);
        carActionHandlerTest.forwardCar("a");
        carActionHandlerTest.forwardCar("b");

        //then
        assertEquals(expectedMap, carActionHandlerTest.getCarList());
    }

}
