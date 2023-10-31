package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class roundNumberTest extends NsTest {
    @Test
    void 최대_라운드_숫자에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji","10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 최소_라운드_숫자에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji","0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열_숫자_변환에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji","a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}
