package racingcar.inputTest;

import org.junit.jupiter.api.Test;
import racingcar.Service.MoveORStop;
import racingcar.View.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTryCountTest {
    @Test
    void 음수_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputView.NegativeNumber(-1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
