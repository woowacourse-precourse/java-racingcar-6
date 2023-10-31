package racingcar.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoundResultDtoTest {

    @Test
    public void givenCarStates_whenGetCarStates_thenReturnCorrectStates() {
        Car car = new Car("Car", 2);
        CarStateDto carState = new CarStateDto(car);
        RoundResultDto dto = new RoundResultDto(Arrays.asList(carState));

        assertEquals(1, dto.getCarStates().size());
        assertEquals("Car : --", dto.getCarStates().get(0).getCarStatus());
    }

    @Test
    public void givenCarStates_whenGetCarStates_thenReturnIncorrectStates() {
        Car car = new Car("Car", 2);
        CarStateDto carState = new CarStateDto(car);
        RoundResultDto dto = new RoundResultDto(Arrays.asList(carState));

        assertNotEquals(2, dto.getCarStates().size());
        assertNotEquals("Car : -", dto.getCarStates().get(0).getCarStatus());
    }
}