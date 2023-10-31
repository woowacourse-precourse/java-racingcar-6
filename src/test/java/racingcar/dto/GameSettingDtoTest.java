package racingcar.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameSettingDtoTest {

    @Test
    public void givenCarNamesAndTryCount_whenGettersCalled_thenReturnCorrectValues() {
        GameSettingDto dto = new GameSettingDto(Arrays.asList("Car1", "Car2"), 5);

        assertEquals(Arrays.asList("Car1", "Car2"), dto.getCarNames());
        assertEquals(5, dto.getTryCount());
    }

    @Test
    public void givenCarNamesAndTryCount_whenGettersCalled_thenReturnIncorrectValues() {
        GameSettingDto dto = new GameSettingDto(Arrays.asList("Car1", "Car2"), 5);

        assertNotEquals(Arrays.asList("Car1", "Car3"), dto.getCarNames());
        assertNotEquals(6, dto.getTryCount());
    }
}