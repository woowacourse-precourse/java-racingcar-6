package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UtilTest {

    @Test
    @DisplayName("유틸__getBooleanByNumber_정상확인")
    void getBooleanByNumber_메서드_사용시_숫자에_따른_참거짓_반환_확인() {
        boolean result = Util.getBooleanByNumber(Config.TRUE_THRESHOLD_NUMBER);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("유틸__getBooleanByNumber_예외확인")
    void getBooleanByNumber_메서드_사용시_한자리_숫자가_아닌_파라미터_입력_예외() {
        List<Integer> numbers = Arrays.asList(34, -1);

        for (int number : numbers) {
            assertThatThrownBy(() -> Util.getBooleanByNumber(number))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}