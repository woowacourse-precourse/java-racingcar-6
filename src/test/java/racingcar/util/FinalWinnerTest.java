package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinalWinnerTest {

    private FinalWinner finalWinner;

    @BeforeEach
    public void setUp() {
        finalWinner = new FinalWinner();
    }

    @Test
    public void testCarsDistanceComparisonWithSoleChampion() {

        Map<String, String> carsDistanceData = new HashMap<>();
        carsDistanceData.put("Car1", "12345");
        carsDistanceData.put("Car2", "1234");
        int numberOfAttempts = 5;


        finalWinner.carsDistanceComparison(carsDistanceData, numberOfAttempts);


        assertThat(finalWinner.getWinnerInformation()).containsExactly("Car1");
    }

}