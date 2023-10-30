package racingcar.ModelTest;

import org.junit.jupiter.api.Test;
import racingcar.Model.RacingCarRandomNumber;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {

    @Test
    void 랜덤_숫자_범위_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCarRandomNumber.validateRandomNumberRange(10))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
