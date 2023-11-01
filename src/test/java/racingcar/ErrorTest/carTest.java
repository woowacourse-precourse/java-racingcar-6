package racingcar.ErrorTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class carTest extends NsTest {
    @Test
    void 문자열_길이에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("HongSeungPyo"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름_앞_공백에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
