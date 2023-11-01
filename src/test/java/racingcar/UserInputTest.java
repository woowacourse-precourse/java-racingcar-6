package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class UserInputTest extends NsTest {
    @Test
    void 이름_한개인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 쉼표_뒤에_공백인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 띄어쓰기가_포함된_이름인_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,wo ni"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름이_중복된_경우_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
