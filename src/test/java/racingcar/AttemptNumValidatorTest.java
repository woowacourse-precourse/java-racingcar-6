package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class AttemptNumValidatorTest extends NsTest {

    @Test
    void 입력_시도회수에_문자가_포함되었을때_예외_처리(){
        assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni,jun", "car"))
                            .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_시도회수가_음수일때_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_시도회수가_소수일때_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "1.34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_시도회수가_공백일때_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}