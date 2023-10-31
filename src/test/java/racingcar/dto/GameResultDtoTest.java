package racingcar.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameResultDtoTest {

    @Test
    public void givenWinnerNames_whenGetWinnerNames_thenReturnCorrectNames() {
        GameResultDto dto = new GameResultDto(Arrays.asList("Car1", "Car2"));
        assertEquals(Arrays.asList("Car1", "Car2"), dto.getWinnerNames());
    }

    @Test
    public void givenWinnerNames_whenGetWinnerNames_thenReturnIncorrectNames() {
        GameResultDto dto = new GameResultDto(Arrays.asList("Car1", "Car2"));
        assertNotEquals(Arrays.asList("Car2", "Car3"), dto.getWinnerNames());
    }
}