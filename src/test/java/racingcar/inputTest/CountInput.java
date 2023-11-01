package racingcar.inputTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CountInput extends NsTest {
    @Test
    void 경기횟수_0입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경기횟수_음수입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,joon", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경기횟수_소수입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,joon", "1.6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경기횟수_숫자가_아닌_문자입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,joon", "ㅡ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름중복_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
