package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.TryCountValidator;
import view.InputView;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {
    @DisplayName("[예외] 시도 횟수 타입 예외 테스트")
    @Test
    void validateTypeTest() {
        assertThatThrownBy(() -> TryCountValidator.validateTryCount("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력해 주세요.");
    }

    @DisplayName("[예외] 시도 횟수 범위 테스트")
    @Test
    void validateRangeTest() {
        assertThatThrownBy(() -> TryCountValidator.validateTryCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최소 1번은 시도해야 합니다.");
    }

}
