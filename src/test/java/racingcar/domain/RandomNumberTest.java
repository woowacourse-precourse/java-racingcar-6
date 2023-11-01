package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberTest {

    @Test
    void isMovable_4_이상이면_참() {
        RandomNumber randomNumber = new RandomNumber(4);
        assertTrue(randomNumber.isMovable());
    }

    @Test
    void isMovable_4_미만이면_거짓() {
        RandomNumber randomNumber = new RandomNumber(3);
        assertFalse(randomNumber.isMovable());
    }

}