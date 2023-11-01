package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest extends NsTest {

    @Test
    void 입력한_자동차_구분자인_콤마_사이에_공백이_존재할때_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni, jun", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한_자동차_이름에_스페이스가_존재할때_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,j un", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한_자동차_길이에_0이_존재할때_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni,jun", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한_자동차_길이가_5를_초과하는_경우_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobiii,woni,jun", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
