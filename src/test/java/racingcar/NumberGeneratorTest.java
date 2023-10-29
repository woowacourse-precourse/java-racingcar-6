package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberGeneratorTest {

    @Test
    void createRandomNumberTest() {
        int randomNumber = NumberGenerator.createRandomNumber();

        assertThat(randomNumber).isBetween(0, 9);
    }
}
