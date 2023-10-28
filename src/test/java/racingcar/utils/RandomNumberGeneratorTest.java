package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {
    final static int TEST_NUMBER = 5;
    final static int MINIMUM_NUMBER_RANGE = 0;
    final static int MAXIMUM_NUMBER_RANGE = 9;

    @DisplayName("무작위 숫자는 0~9사이의 숫자여야 한다.")
    @RepeatedTest(TEST_NUMBER)
    void 무작위_숫자_범위_유효성_테스트() {
        //given, when
        int randomNumber = RandomNumberGenerator.generate();

        //then
        assertThat(randomNumber)
                .matches(v -> MINIMUM_NUMBER_RANGE <= v && v <= MAXIMUM_NUMBER_RANGE);
    }
}
