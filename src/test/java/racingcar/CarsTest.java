package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("red", "green", "blue");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        cars = new Cars(carList);
    }

    @Test
    void getCarsStatus_테스트() {
        Map<String, Integer> result = cars.getCarsStatus();

        assertTrue(result.containsKey("red"));
        assertEquals(0, result.get("red"));
        assertTrue(result.containsKey("green"));
        assertEquals(0, result.get("green"));
        assertTrue(result.containsKey("blue"));
        assertEquals(0, result.get("blue"));
    }
}
