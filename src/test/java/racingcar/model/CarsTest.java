package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void testGenerateCars() {
        String[] carNames = {"car1", "car2", "car3"};
        Cars cars = Cars.generateCars(carNames);
        List<String> names = cars.getName();
        List<Integer> scores = cars.getScore();
        assertNotNull(cars);
        assertEquals(3, names.size());

        for (String carName : carNames) {
            assertTrue(names.contains(carName));
            assertEquals(0, scores.get(names.indexOf(carName)));
        }
    }
}