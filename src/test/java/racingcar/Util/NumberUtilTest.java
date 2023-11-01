package racingcar.Util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberUtilTest {
    @Test
    @DisplayName("숫자 생성 테스트")
    void 숫자_생성_테스트() {
        int n = NumberUtil.create();
        assertThat(n).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("입력 숫자 검증 테스트")
    void 입력_숫자_검증_테스트() {
        assertThatThrownBy(() -> NumberUtil.validateNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 숫자가 아닙니다.");
    }
}