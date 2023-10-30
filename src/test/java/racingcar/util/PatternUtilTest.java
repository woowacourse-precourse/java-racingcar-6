package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatternUtilTest {
        @Test
        @DisplayName("확인: 양수인지 검사하는 정규표현식")
        void check_only_positive_number_pattern() {
                assertThat(PatternUtil.ONLY_POSITIVE_NUMBER_PATTERN).isEqualTo("^[0-9]\\d*$");
        }
}
