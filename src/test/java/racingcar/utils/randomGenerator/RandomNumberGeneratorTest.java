package racingcar.utils.randomGenerator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    public static final int MIN_DIGIT = 0;
    public static final int MAX_DIGIT = 9;

    @Test
    void 랜덤_숫자_생성기_테스트() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

        // when
        int result = randomNumberGenerator.generateRandomSingleDigit();

        // then
        assertThat(result).isGreaterThanOrEqualTo(MIN_DIGIT).isLessThanOrEqualTo(MAX_DIGIT);
    }

}