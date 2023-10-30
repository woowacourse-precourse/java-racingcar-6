package racingcar;

import org.junit.jupiter.api.Test;

import racingcar.model.GenerateRandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateRandomNumberTest {

    @Test
    void testGetRandomNumberInRange() {
        GenerateRandomNumber generator = GenerateRandomNumber.create();

        int randomNumber = generator.getRandomNumber();

        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    void testGetRandomNumberMultipleTimes() {
        GenerateRandomNumber generator = GenerateRandomNumber.create();

        int randomNumber1 = generator.getRandomNumber();
        int randomNumber2 = generator.getRandomNumber();

        assertThat(randomNumber1).isNotEqualTo(randomNumber2);
    }
}