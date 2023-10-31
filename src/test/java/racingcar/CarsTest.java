package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {
    private List<Car> carList;
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("red", "green", "blue");
        carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        cars = new Cars(carList);
    }

    @Test
    void getCarsStatus_테스트() {
        carList.get(0).move();
        carList.get(0).move();

        Map<String, Integer> result = cars.getCarsStatus();

        assertTrue(result.containsKey("red"));
        assertEquals(2, result.get("red"));
        assertTrue(result.containsKey("green"));
        assertEquals(0, result.get("green"));
        assertTrue(result.containsKey("blue"));
        assertEquals(0, result.get("blue"));
    }

    @Test
    void findMaxPosition_테스트() {
        carList.get(1).move();
        carList.get(1).move();

        assertEquals(2, cars.findMaxPosition());
    }

    @Test
    void findCarNamesAt_테스트() {
        carList.get(0).move();
        carList.get(1).move();

        List<String> result = cars.findCarNamesAt(1);

        assertEquals(2, result.size());
        assertThat(result).contains("red").contains("green");
    }
}
