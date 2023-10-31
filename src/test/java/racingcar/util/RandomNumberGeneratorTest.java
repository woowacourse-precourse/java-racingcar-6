package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {
    @RepeatedTest(1000)
    @DisplayName("랜덤값이 0 이상 9 이하인지 검사")
    void 랜덤값_범위_검사() {
        int number = RandomNumberGenerator.getRandomNumber();
        assertThatCode(() -> RandomNumberValidator.validate(number))
                .doesNotThrowAnyException();
    }
}
