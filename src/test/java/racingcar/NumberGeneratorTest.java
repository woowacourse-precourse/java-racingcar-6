package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.NumberGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberGeneratorTest {

    @Test
    void 랜덤_값_범위() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = NumberGenerator.generateRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber <= 9, "0부터 9 사이의 숫자가 아닙니다.");
        }
    }
}
