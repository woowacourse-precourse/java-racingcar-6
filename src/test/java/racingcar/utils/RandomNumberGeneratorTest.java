package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @DisplayName("0~9 사이의 랜덤 수를 잘 생성하는지 테스트")
    @RepeatedTest(100)
    void testGenerateRandomNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        int number = generator.generateRandomNumber();

        assertTrue(number >= 0 && number <= 9);
    }
}
