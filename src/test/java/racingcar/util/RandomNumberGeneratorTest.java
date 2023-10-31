package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    private static final Integer RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final Integer RANDOM_NUMBER_END_INCLUSIVE = 9;

    @RepeatedTest(value = 5)
    @DisplayName("0에서 9사이 무작위의 값 랜덤 생성 테스트")
    @Test
    void pick() {
        // Arrange
        int randomNumber = RandomNumberGenerator.pick();

        // Act & Assert
        Assertions.assertTrue(
                RANDOM_NUMBER_START_INCLUSIVE <= randomNumber &&
                randomNumber <= RANDOM_NUMBER_END_INCLUSIVE);
    }
}