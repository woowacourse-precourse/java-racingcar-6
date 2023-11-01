package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void given() {
        car = new Car("Test");
    }
    @Test
    @DisplayName("Car의 move()를 먼저 테스트")
    public void testCarMove(){
        //given
        car.move(5);

        //when
        int expect = 1;
        int actual = car.getPosition();

        //then
        assertEquals(expect, actual);
    }

}