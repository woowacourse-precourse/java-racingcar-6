package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest extends NsTest {

    @Test
    void 이름_길이에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,car123", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,car1", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 반복_횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,car2", "e"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
