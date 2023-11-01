package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {

    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    @RepeatedTest(100)
    void 숫자_생성_확인() {
        int number = RandomNumberGenerator.generate();

        assertThat(number).isGreaterThanOrEqualTo(START_RANGE).isLessThanOrEqualTo(END_RANGE);
    }
}
