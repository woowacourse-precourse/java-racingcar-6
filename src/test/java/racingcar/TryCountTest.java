package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {

    @Test
    void 시도_횟수_앞에_있는_0_제거_테스트() {
        assertThat(new TryCount("000123456789").getTryCount())
                .isEqualTo(123456789);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 시도_횟수_비어있을_경우_테스트(String tryCount) {
        assertThatThrownBy(() -> new TryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"000123456789", "123456789"})
    void 시도_횟수_자릿수_성공_테스트(String tryCount) {
        assertThatCode(() -> new TryCount(tryCount))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수_자릿수_실패_테스트() {
        assertThatThrownBy(() -> new TryCount("1234567890"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이하의 수여야 합니다.");
    }

    @Test
    void 시도_횟수_문자_입력_테스트() {
        assertThatThrownBy(() -> new TryCount("three"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "00", "0000000000"})
    void 시도_횟수_음수_그리고_0_입력_테스트(String tryCount) {
        assertThatThrownBy(() -> new TryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이상이어야 합니다.");
    }
}
