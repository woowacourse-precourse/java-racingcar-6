package racingcar.util;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckerTest {
    private final Checker checker = new Checker();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 자동차이름_공백_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> checker.checkCarNamesInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 자동차이름_1글자미만() {
        assertSimpleTest(() -> assertThatThrownBy(() -> checker.checkCarNamesInput("a,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
        assertSimpleTest(() -> assertThatThrownBy(() -> checker.checkCarNamesInput("a,b,,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 자동차이름_5글자초과() {
        assertSimpleTest(() -> assertThatThrownBy(() -> checker.checkCarNamesInput("a,b,abcdefg"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 자동차이름_공백() {
        assertSimpleTest(() -> assertThatThrownBy(() -> checker.checkCarNamesInput("a, ,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }

    @Test
    void 자동차이름_중복() {
        assertSimpleTest(() -> assertThatThrownBy(() -> checker.checkCarNamesInput("a,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE));
    }
}
