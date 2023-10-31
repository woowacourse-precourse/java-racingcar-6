package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {
    @Test
    void generateSingleDigit_메서드는_0부터_9까지의_한자리_수만_반환() {
        int unboundCount = 0;
        for (int i = 0; i < 50000; i++) {
            int digit = RandomNumber.generateSingleDigit();
            if (digit < 0 || digit > 9) {
                unboundCount++;
            }
        }
        assertThat(unboundCount).isEqualTo(0);
    }
}
