package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("Car의 move()를 먼저 테스트")
    public void testCarMove(){
        //given
        Car car = new Car("TestCar");
        car.move(5);

        //when
        int position = car.getPosition();

        //then
        assertEquals(5, position);
    }
}
