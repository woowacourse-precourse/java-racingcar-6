package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputCarNamesTest extends NsTest {

    @Test
    void 이름_길이초과_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름_공백포함_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,ja i", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름_마지막쉼표_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jav,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름_중복이름_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
