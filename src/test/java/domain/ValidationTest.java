package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class ValidationTest extends NsTest {
    @Test
    void 이름_예외_처리_빈_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_공백문자1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_공백문자2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,j un"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_6자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jjuunn"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_처리_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_예외_처리_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class));
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
