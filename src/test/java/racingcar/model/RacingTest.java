package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorCode;

public class RacingTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 경주매니저_생성시_이동_시도_횟수가_0회_이하면_예외가_발생한다(int tryCount) {
        assertThatThrownBy(() -> new Racing(List.of("test"), tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NON_POSITIVE_TRY_COUNT.getMessage());
    }
}
