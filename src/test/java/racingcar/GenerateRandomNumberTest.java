package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.model.GenerateRandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateRandomNumberTest {

    private GenerateRandomNumber generateRandomNumber;

    @BeforeEach
    void setUp() {
        generateRandomNumber = new GenerateRandomNumber();
    }

    @Test
    void generateRandomNumber_ShouldReturnNumbersInRange() {
        for (int expectedRandomNumber = 0; expectedRandomNumber <= 9; expectedRandomNumber++) {
            generateRandomNumber.generateRandomNumber();

            int result = generateRandomNumber.randomNumber;
            assertThat(result).isGreaterThanOrEqualTo(0);
            assertThat(result).isLessThanOrEqualTo(9);
        }
    }
}