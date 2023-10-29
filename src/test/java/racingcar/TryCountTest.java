package racingcar;

import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import validator.TryCountValidator;
import view.InputView;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {
    @DisplayName("시도 횟수를 입력받아서 저장하는 기능")
    @Test
    void inputTryCountTest() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        assertThat(3).isEqualTo(InputView.inputTryCount());
    }

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
