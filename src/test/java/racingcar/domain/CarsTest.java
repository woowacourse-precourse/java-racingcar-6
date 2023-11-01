package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private Cars cars;
    private String input = "pobi,jun,woni";

    @BeforeEach
    void setUp() {
        cars = new Cars(input);
    }

    @Test
    void 생성자_확인_테스트코드(){
        //when
        assertNotNull(cars);
        //then
        assertEquals(3, cars.cars.size());
    }


}