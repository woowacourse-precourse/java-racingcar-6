package racingcarv2.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcarv2.util.RandomGenerator;

public class RandomGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
    void 랜덤_수_생성_확인(int startInclusive, int endInclusive) {
        int randomNumber = RandomGenerator.generateRandomNumber(startInclusive, endInclusive);

        Assertions.assertThat(randomNumber).isEqualTo(startInclusive);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:9"}, delimiter = ':')
    void 랜덤_수_범위_확인(int startInclusive, int endInclusive) {
        int randomNumber = RandomGenerator.generateRandomNumber(startInclusive, endInclusive);

        org.junit.jupiter.api.Assertions.assertTrue(randomNumber <= 9);
        org.junit.jupiter.api.Assertions.assertTrue(randomNumber >= 1);
    }


}
