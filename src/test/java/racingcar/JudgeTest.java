package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.judge.Judge;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgeTest {
    @Test
    void calculateWinnersTest() {
        // Given
        Judge judge = new Judge();
        Map<String, String> driverMap = new HashMap<>();
        driverMap.put("pobi", "-----");
        driverMap.put("woni", "----");
        driverMap.put("jun", "-----");

        // When
        String winners = judge.calculateWinners(driverMap);

        // Then
        assertEquals("pobi, jun", winners);
    }
}
