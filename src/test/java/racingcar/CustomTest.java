package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomTest extends NsTest {
    @Test
    void 입력받은_시도횟수_양수인지_판별() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_시도횟수_공백인지_판별() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 입력받은_시도횟수_숫자인지_판별() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_자동차_이름이_한글인지_판별() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("이이,김김", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_자동차_이름이_공백인지_판별() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_자동차_이름이_숫자인지_판별() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123,234", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
