package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberTest {

    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;

    @DisplayName("랜덤수 생성 테스트")
    @Test
    void generateNumberInRange() {
        int generateNumber = RandomNumber.generateNumber();
        assertTrue(isCorrectNumber(generateNumber));
    }

    private boolean isCorrectNumber(int generateNumber) {
        return (generateNumber >= RANDOM_MIN_NUMBER && generateNumber <= RANDOM_MAX_NUMBER);
    }
}