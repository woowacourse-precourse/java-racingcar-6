package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayCountTest {

    @Test
    @DisplayName("정상적인 횟수를 입력했을 시 문제 없어야 한다.")
    void validNumberInputTest() {
        // when & then
        assertDoesNotThrow(() -> PlayCount.createDefault("5"));
    }
}
