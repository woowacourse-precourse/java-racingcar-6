package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.message.ExceptionMessage;

public class ExceptionTest extends NsTest {

    @Test
    void 이름에_중복_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi, psm"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 이름에_숫자_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, 1, woni"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
