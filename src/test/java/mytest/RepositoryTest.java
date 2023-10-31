package mytest;

import org.junit.jupiter.api.Test;
import repository.CarListRepository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RepositoryTest {
    @Test
    void repository_테스트() {
        Map<String, Integer> carListTestMap = new HashMap<>();
        carListTestMap.put("a", 0);
        carListTestMap.put("b", 1);
        carListTestMap.put("c", 0);

        Map<String, Integer> carListInputMap = new LinkedHashMap<>();
        carListInputMap.put("a", 0);
        carListInputMap.put("b", 0);
        carListInputMap.put("c", 0);

        CarListRepository carListRepository = new CarListRepository(carListInputMap);

        carListRepository.forwardCar("b");

        assertEquals(carListTestMap, carListRepository.getCarList());
    }
}