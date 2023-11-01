package mytest;

import org.junit.jupiter.api.Test;
import repository.CarListRepository;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RepositoryTest {
    @Test
    void repository_테스트() {
        //given
        LinkedHashMap<String, Integer> carListTestMap = new LinkedHashMap<>();
        carListTestMap.put("a", 0);
        carListTestMap.put("b", 1);
        carListTestMap.put("c", 0);
        LinkedHashMap<String, Integer> carListInputMap = new LinkedHashMap<>();
        carListInputMap.put("a", 0);
        carListInputMap.put("b", 0);
        carListInputMap.put("c", 0);

        //when
        CarListRepository carListRepository = new CarListRepository(carListInputMap);
        carListRepository.forwardCar("b");

        //then
        assertEquals(carListTestMap, carListRepository.carList());
    }
}