package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingUtilTest {
    @Test
    void generateRandomPower_테스트() {
        int result = RacingUtil.generateRandomPower();

        assertThat(result).isBetween(0, 9);
    }

    @Test
    void createCarsFromNames_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");

        List<Car> resultList = RacingUtil.createCarsFromNames(inputList);

        assertEquals(inputList.get(0), resultList.get(0).getName());
        assertEquals(inputList.get(1), resultList.get(1).getName());
        assertEquals(inputList.get(2), resultList.get(2).getName());
    }
}
