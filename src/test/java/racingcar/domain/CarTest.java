package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.GameRule;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void 랜덤수_범위체크() {
        // given

        // when
        int number = car.generateNumber();

        // then
        assertTrue(number >= GameRule.MIN_INPUT_NUMBER && number <= GameRule.MAX_INPUT_NUMBER);
    }

    @Test
    void 랜덤수_4이상이면_전진() {
        // given

        // when
        int randomNumber = 4;

        // then
        car.moveForward(randomNumber);
        assertEquals(1, car.getMoveCnt());
    }

    @Test
    void 랜덤수_3이하면_정지() {
        // given

        // when
        int randomNumber = 3;

        // then
        car.moveForward(randomNumber);
        assertEquals(0, car.getMoveCnt());
    }
}