package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TrialNumber;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TrialNumberTest {
    @Test
    void 시도쵯수_숫자아닌값_예외처리_테스트() {
        assertThatThrownBy(() -> new TrialNumber("d123")).isInstanceOf(IllegalArgumentException.class);
    }
}
