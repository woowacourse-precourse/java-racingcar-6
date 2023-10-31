package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.model.validator.CarNameValidator;
import racingcar.model.validator.MovingCountValidator;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    CarNameValidator carNameValidator = new CarNameValidator();
    MovingCountValidator movingCountValidator = new MovingCountValidator();

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름_입력값검증() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{"Hello,,World"}))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{"Hello,Hello,Hello"}))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{""}))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{"Hello",",","World,"}))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{"OverLength"}))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{"한글여섯글자"}))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{"^&#(*!"}))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> carNameValidator.checkNameValidation(new String[]{"     ", ""}))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 이동횟수_입력값검증() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> movingCountValidator.checkMovementCount("-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> movingCountValidator.checkMovementCount("101"))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> movingCountValidator.checkMovementCount("abc"))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> movingCountValidator.checkMovementCount("1.5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
