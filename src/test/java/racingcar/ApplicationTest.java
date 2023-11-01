package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Validator.CarNameValidator;
import racingcar.Validator.TrialCountValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 지정된_구분자가_아닌_다른_구분자_사용에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi/woni", "2"))
                        .isInstanceOf(IllegalArgumentException.class));

    }

    @Test
    void 자동차가_10대_이상_입력된_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름이_공백으로_입력된_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarNameValidator.validateCarNames(""))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_음수를_입력한_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> TrialCountValidator.validateTrialCount("-2"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 실행_횟수에_문자를_입력한_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> TrialCountValidator.validateTrialCount("세번"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
