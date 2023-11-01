package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {

    @Test
    @DisplayName("랜덤 넘버 범위는 1~9다.")
    void checkRandomNumberInRange() {
        // given
        Integer min = 1;
        Integer max = 9;
        // when
        Integer randomNumber = RandomNumber.createRandomNumber(min,max);
        // then
        assertTrue(randomNumber >= min && randomNumber <= max);
    }
}
