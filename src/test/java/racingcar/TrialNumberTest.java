package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.TrialNumber;

public class TrialNumberTest {
    @Test
    @DisplayName("시도회수 생성 테스트")
    void 시도회수_생성() {
        TrialNumber trial = new TrialNumber("1");
        Assertions.assertThat(trial).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2"})
    @DisplayName("시도회수 음수 입력 테스트")
    void 시도회수_음수_입력(String string) {
        Assertions.assertThatThrownBy(() -> new TrialNumber(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " ", ","})
    @DisplayName("시도회수 문자 입력 테스트")
    void 시도회수_문자_입력(String string) {
        Assertions.assertThatThrownBy(() -> new TrialNumber(string))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
