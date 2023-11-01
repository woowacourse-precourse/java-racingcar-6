package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.utils.CarNameValidator;
import racingcar.utils.TrialNumberValidator;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class ValidatorTest {

    @Test
    void 자동차이름_1글자미만_입력() {
        String carNames = "";
        assertThatThrownBy(() -> new CarNameValidator(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
