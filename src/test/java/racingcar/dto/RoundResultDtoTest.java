package racingcar.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoundResultDtoTest {

    @Test
    public void givenCarStates_whenGetCarStates_thenReturnCorrectStates() {
        CarStateDto carState = new CarStateDto("Car : --");
        RoundResultDto dto = new RoundResultDto(Arrays.asList(carState));

        assertEquals(1, dto.getCarStates().size());
        assertEquals("Car : --", dto.getCarStates().get(0).getCarStatus());
    }

    @Test
    public void givenCarStates_whenGetCarStates_thenReturnIncorrectStates() {
        CarStateDto carState = new CarStateDto("Car : --");
        RoundResultDto dto = new RoundResultDto(Arrays.asList(carState));

        assertNotEquals(2, dto.getCarStates().size());
        assertNotEquals("Car : -", dto.getCarStates().get(0).getCarStatus());
    }
}