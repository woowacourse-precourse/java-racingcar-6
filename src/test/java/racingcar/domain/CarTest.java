package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    public void testMoveCar() {
        RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.createRandomNumber())
                .thenReturn(3)
                .thenReturn(5);

        Car car = new Car("phobi", mockGenerator, 0);

        // move 메서드 호출
        car.move(); // randomNumber = 3
        car.move(); // randomNumber = 5

        assertEquals(1, car.getPosition());
    }
}