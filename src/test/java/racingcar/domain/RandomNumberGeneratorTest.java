package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberGeneratorTest {

    private final int START_INCLUSIVE = 0;
    private final int MIDDLE_NUM = 4;
    private final int END_INCLUSIVE = 9;

    @Test
    @DisplayName("0과 9포함한 랜덤값으로 1자리르 구성하는지 체크")
    void is_singel_digit_random_value() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(RandomNumberGenerator.randomNumGenerate())
                            .isEqualTo(START_INCLUSIVE);
                    assertThat(RandomNumberGenerator.randomNumGenerate())
                            .isEqualTo(MIDDLE_NUM);
                    assertThat(RandomNumberGenerator.randomNumGenerate())
                            .isEqualTo(END_INCLUSIVE);
                },
                START_INCLUSIVE, MIDDLE_NUM, END_INCLUSIVE
        );
    }
}