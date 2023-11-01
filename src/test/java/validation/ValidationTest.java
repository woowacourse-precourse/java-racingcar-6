package validation;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest extends NsTest {

    @Test
    void 자동차_이름과_시도_횟수_정상_입력() {
        assertThatCode(() -> run("car1, car2, car3", "1"))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름이_공백일_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("공백인 자동차 이름이 존재합니다.")
        );
    }

    @Test
    void 자동차_이름예_중복이_있을_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car, car", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복된 자동차 이름이 존재합니다.")
        );
    }

    @Test
    void 시도_횟수_입력이_문자일_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, car2", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자를 입력해 주세요.")
        );
    }

    @Test
    void 시도_횟수_입력이_없는_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, car2", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자를 입력해 주세요.")
        );
    }

    @Test
    void 시도_횟수_숫자가_0_이하일_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1, car2", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 이상의 숫자를 입력해 주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
