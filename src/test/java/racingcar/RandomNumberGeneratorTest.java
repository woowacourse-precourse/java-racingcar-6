package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("생성된 수가 범위 안에 맞는지 테스트")
    void generateRandom() {
        int number = RandomNumberGenerator.generateNumber();
        assertTrue(number >= 0 && number <= 9, "생성된 수가 0부터 9까지의 수가 아닙니다.");
    }

}