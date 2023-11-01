package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("전진 검증")
    @Test
    void go() {
        //given
        Car car = new Car("pobi", 0);
        int moveNumber = 5;

        //when
        for(int i=0; i<moveNumber; i++) {
            car.go();
        }

        //then
        assertAll(
                () -> assertEquals(5, car.getProgress()),
                () -> assertEquals("-----", car.getDash())
        );
    }
}
