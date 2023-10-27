package racingcar;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarTest {

    @BeforeEach
    void setup() {
        if (!Mockito.mockingDetails(RandomNumberGenerator.class).isMock()) {
            mockStatic(RandomNumberGenerator.class);
        }
    }

    @Test
    @DisplayName("자동차가 이동하는 경우")
    void moveSuccess() {
        // given
        Car car = new Car("pobi");
        assertEquals(0, car.getPosition());

        // when
        when(RandomNumberGenerator.generateNumber()).thenReturn(4);
        car.move();

        // then
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차가 정지하는 경우")
    void moveFail() {
        // given
        Car car = new Car("kong");
        assertEquals(0, car.getPosition());

        // when
        when(RandomNumberGenerator.generateNumber()).thenReturn(0);
        car.move();

        // then
        assertEquals(0, car.getPosition());
    }
}