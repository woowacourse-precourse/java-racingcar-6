package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 랜덤숫자_0부터_9_사이인지_확인() {
        for (int i = 0; i < 10; i++) {
            int randomNumber = NumberGenerator.createRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber <= 9, "Number should be between 0 and 9");
        }
    }
}