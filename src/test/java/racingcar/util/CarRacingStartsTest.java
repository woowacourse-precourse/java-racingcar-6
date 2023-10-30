package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.util.CarRacingStarts;
import racingcar.util.PickRandomNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarRacingStartsTest {

    @Test
    void testCarCreation() {
        // Arrange
        PickRandomNumber mockRandomNumberGenerator = mock(PickRandomNumber.class);
        when(mockRandomNumberGenerator.Generation()).thenReturn(4); // Adjust this value as needed for testing.

        CarRacingStarts carRacingStarts = new CarRacingStarts(mockRandomNumberGenerator);
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        // Act
        carRacingStarts.creation(carNames);
        Map<String, String> carsDistanceData = carRacingStarts.getCarsDistanceData();

        // Assert
        assertEquals(3, carsDistanceData.size()); // Ensure that all cars are accounted for.

        for (String carName : carNames) {
            String distanceInfo = carsDistanceData.get(carName);
            assertEquals(distanceInfo.length(), 1); // Ensure that the distance information is valid (either '-' or empty).
        }
    }
}

