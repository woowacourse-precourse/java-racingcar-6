package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Generator;

public class GeneratorTest {

    @DisplayName("0-9 랜덤 숫자 생성 기능 테스트")
    @Test
    void testGenerateRandomNumber() {
        Generator generator = new Generator();
        for (int time = 0; time < 100; time++) {
            int randomNumber = generator.generateRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }
}
