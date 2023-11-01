package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    @Test
    @DisplayName("성공 : 1 ~ 9 사이의 랜덤 숫자 생성")
    void generateRandomNumberForSuccess() {
        // when
        int randomNumber = RandomNumberGenerator.generate();

        // then
        assertTrue(randomNumber >= START_NUMBER && randomNumber <= END_NUMBER);
    }
}
