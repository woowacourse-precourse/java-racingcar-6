package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest extends NsTest {
    @Test
    void 이름이_없는_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_5자_이상인_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ppororo", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_중복되는_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_공백이_포함된_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ppobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 참가_자동차가_2대_이하인_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_횟수가_문자인_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,nari", "w"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_횟수가_음수인_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,nari", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_횟수가_0인_경우_예외처리 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,nari", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
