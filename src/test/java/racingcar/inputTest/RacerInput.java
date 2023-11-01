package racingcar.inputTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class RacerInput extends NsTest {
    @Test
    void 이름길이_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름공백입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,joon", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름하나입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름중복_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
