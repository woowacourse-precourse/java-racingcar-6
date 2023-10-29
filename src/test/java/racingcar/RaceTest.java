package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {
    @Test
    void createCarObjectsTest() {
        // Given
        Race race = new Race();
        String[] carNames = { "Car1", "Car2", "Car3" };

        // When
        race.createCarObjects(carNames);

        // Then
        List<Car> cars = race.cars;
        assertEquals(carNames.length, cars.size());
        for (int i = 0; i < carNames.length; i++) {
            assertEquals(carNames[i], cars.get(i).getName());
        }
    }



}
