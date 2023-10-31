package racingcar.race;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import racingcar.race.Car;
import racingcar.util.PickRandomNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarTest {

    @Test
    void testCarCreation() {
        // Arrange
        PickRandomNumber mockRandomNumberGenerator = mock(PickRandomNumber.class);
        when(mockRandomNumberGenerator.Generation()).thenReturn(4); // Adjust this value as needed for testing.

        Car car = new Car(mockRandomNumberGenerator);
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        // Act
        car.racingStarts(carNames);
        Map<String, String> carsDistanceData = car.getCarsDistanceData();

        // Assert
        assertEquals(3, carsDistanceData.size()); // Ensure that all cars are accounted for.

        for (String carName : carNames) {
            String distanceInfo = carsDistanceData.get(carName);
            assertEquals(distanceInfo.length(), 1); // Ensure that the distance information is valid (either '-' or empty).
        }
    }
}

