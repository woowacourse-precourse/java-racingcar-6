package racingcar.util;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class ExceptionTest {
    private final Exception exception = new Exception();

    @Test
    void 자동차이름_5글자_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkCarNamesInput("a,b,asdvcx"))
                .isInstanceOf(IllegalArgumentException.class));
    }
}
