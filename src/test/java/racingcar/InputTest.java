package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {

    @Test
    @DisplayName("이름길이 5초과")
    void 이름길이테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello~,hi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복이름 테스트")
    void 이름중복() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("CarA,CarA"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("이름 공백 테스트")
    void 이름공백() {
        assertSimpleTest(()->{
            assertThatThrownBy(() -> runException("hello,world,,,"))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(()->{
            assertThatThrownBy(() -> runException("hello, ,world"))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(()->{
            assertThatThrownBy(() -> runException("\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("시도횟수 음수 테스트")
    void 시도횟수음수() {
        assertSimpleTest(()->{
            assertThatThrownBy(() -> runException("ki,yoon", "-10"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
