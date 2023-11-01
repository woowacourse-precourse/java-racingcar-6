package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {

    @Test
    void 자동차_이름의_길이가_5_초과인지_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,EveKristinLee", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_빈_문자열인지_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("EveKristinLee,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_중복되는지_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("EveKristinLee,EveKristinLee", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수가_숫자인지_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,EveKristinLee", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도할_횟수가_0이상인지_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,EveKristinLee", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
