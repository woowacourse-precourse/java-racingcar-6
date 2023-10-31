package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @Test
    void 항상_0이상_9이하_랜덤숫자_확인() {
        for (int i = 0; i < 1000; i++) {
            int randomNumber = RandomNumber.createRandomNumber();

            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }
}
