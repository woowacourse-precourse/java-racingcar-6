package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    void testRandomNumberArrayCreation() {
        int size = 30;
        int[] numbers = NumberGenerator.generateRandomNumbers(size);

        for (int number : numbers) {
            assertThat(number).isBetween(1, 9);
        }
    }
}
