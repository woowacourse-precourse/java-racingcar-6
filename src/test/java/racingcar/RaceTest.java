package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    void updateCarsPositionTest() {
        // Given
        Race race = new Race();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        race.cars.add(car1);
        race.cars.add(car2);
        race.cars.add(car3);

        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.createRandomNumber()).thenReturn(1,4,5);
        race.numberGenerator = numberGenerator;

        // When
        race.updateCarsPosition();

        // Then
        assertEquals(0, car1.getPosition());
        assertEquals(1, car2.getPosition());
        assertEquals(1, car3.getPosition());
    }



}
