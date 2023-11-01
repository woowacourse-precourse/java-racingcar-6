package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RandomNumber 클래스")
class RandomNumberTest {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    @Test
    void 랜덤_값은_1_이상_9_이하_수를_반환() {
        int number = RandomNumber.generateRandomNumber();
        assertTrue(number >= START_INCLUSIVE && number <= END_INCLUSIVE);
    }
}