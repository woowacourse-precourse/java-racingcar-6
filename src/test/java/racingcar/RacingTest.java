package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;


import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest extends NsTest{

    @Test
    void 중복된_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이초과_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abceefef,pobi,jun", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차가_1개만_주어진_것에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 주어진_횟수가_숫자인_것에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
