package racingcar;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    @Test
    void testNumberGenerator() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomNumbers.add(NumberGenerator.createRandomNumber());
        }
        for (int number : randomNumbers) {
            assertThat(number).isGreaterThanOrEqualTo(0).isLessThan(10);
        }
    }
}
