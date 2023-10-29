package mytest;

import org.junit.jupiter.api.Test;
import repository.CarListRepository;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RepositoryTest {
    @Test
    void repository_테스트() {
        HashMap<String, Integer> carListTestHash = new LinkedHashMap<>();
        carListTestHash.put("a", 0);
        carListTestHash.put("b", 0);
        carListTestHash.put("c", 0);

        String carList = "a,b,c";
        CarListRepository carListRepository = new CarListRepository();
        carListRepository.setCarListRepository(carList);

        assertEquals(carListTestHash, carListRepository.carList);
    }
}