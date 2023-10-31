package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarStateDtoTest {

    @Test
    public void givenCarStatus_whenGetCarStatus_thenReturnCorrectStatus() {
        CarStateDto dto = new CarStateDto("Car : --");
        assertEquals("Car : --", dto.getCarStatus());
    }

    @Test
    public void givenCarStatus_whenGetCarStatus_thenReturnIncorrectStatus() {
        CarStateDto dto = new CarStateDto("Car : --");
        assertNotEquals("Car : -", dto.getCarStatus());
    }
}