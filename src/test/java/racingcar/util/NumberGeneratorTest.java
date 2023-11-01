package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.NumberGenerator.MAX_NUMBER;
import static racingcar.util.NumberGenerator.MIN_NUMBER;
import static racingcar.util.NumberGenerator.generateRandomNumbers;

class NumberGeneratorTest {

    @Test
    void testRandomNumberArrayCreation() {
        int size = 30;
        int[] numbers = generateRandomNumbers(size);

        for (int number : numbers) {
            assertThat(number).isBetween(MIN_NUMBER, MAX_NUMBER);
        }
    }
}
