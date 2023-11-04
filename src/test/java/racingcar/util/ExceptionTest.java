package racingcar.util;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class ExceptionTest {
    private final Exception exception = new Exception();

    @Test
    void 자동차이름_6글자_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkCarNamesInput("a,b,asdvacx"))
                .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 자동차이름_0_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkCarNamesInput("a,,a,a"))
                .isInstanceOf(IllegalArgumentException.class));
    }
    @Test
    void 자동차이름_공백_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차이름_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkCarNamesInput("a,a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도횟수_공백() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkNumberOfPlayCountInput(""))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도횟수_문자입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkNumberOfPlayCountInput("a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_끝에쉼표() {
        assertSimpleTest(() -> assertThatThrownBy(() -> exception.checkNumberOfPlayCountInput("a,"))
                .isInstanceOf(IllegalArgumentException.class));
    }
}
