package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputDeviceTest  extends NsTest {
    @Test
    void 자동차_이름_글자수_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("javaji"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백시작_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ja"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_입력_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ja", "ㅁ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
