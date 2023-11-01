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

    @Test
    void 자동차_이름이_5자가_넘어가는_경우() {
        String carNames = "pobipobi,jun,paul";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carNamesValidation(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_빈_문자열인_경우() {
        String carNames = "pobi,,jun";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> carNamesValidation(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수가_음수인_경우() {
        String repetitions = "-5";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkIsPositiveInteger(repetitions))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수가_0인_경우() {
        String repetitions = "0";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkIsPositiveInteger(repetitions))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_회수가_정수가_아닌_경우() {
        String repetitions = "2.3";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> checkIsPositiveInteger(repetitions))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
