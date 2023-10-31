package racingcar.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarStateDtoTest {

    @Test
    public void givenCarStatus_whenGetCarStatus_thenReturnCorrectStatus() {
        Car car = new Car("Car", 2);
        CarStateDto dto = new CarStateDto(car);
        assertEquals("Car : --", dto.getCarStatus());
    }

    @Test
    public void givenCarStatus_whenGetCarStatus_thenReturnIncorrectStatus() {
        Car car = new Car("Car", 2);
        CarStateDto dto = new CarStateDto(car);
        assertNotEquals("Car : -", dto.getCarStatus());
    }
}