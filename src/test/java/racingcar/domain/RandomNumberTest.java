package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RandomNumber 클래스")
class RandomNumberTest {

    @Test
    void 랜덤_값은_1_이상_9_이하_수를_반환() {
        RandomNumber randomNumber = new RandomNumber();
        int number = randomNumber.generateRandomNumber();

        assertTrue(number >= 1 && number <= 9);
    }
}