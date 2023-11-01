package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;

    @RepeatedTest(value = 5)
    @DisplayName("0에서 9사이 무작위의 값 랜덤 생성 테스트")
    void pick() {
        // Arrange
        int randomNumber = RandomNumberGenerator.pick();

        // Act & Assert
        Assertions.assertTrue(RANDOM_NUMBER_START <= randomNumber && randomNumber <= RANDOM_NUMBER_END);
    }
}