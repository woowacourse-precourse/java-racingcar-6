package racingcar;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static racingcar.Validator.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 자동차_이름이_공백인_경우() {
        String carNames = "pobi,jun, ";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carNamesValidation(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
