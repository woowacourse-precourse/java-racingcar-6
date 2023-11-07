package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import racingcar.view.userInput;

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
    void 자동차_이름_중복에_대한_예외_처리() {
        List<String> carNames = new ArrayList<>(Arrays.asList("alice","alice","paul")) ;

        assertThatThrownBy(() -> userInput.validateNames(carNames)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("차량이름이 중복되었습니다.");
    }

    @Test
    void 자동차_길이_제한_초과에_대한_예외_처리() {
        List<String> carNames = new ArrayList<>(Arrays.asList("aliceeeee","johnnnnn","paulllllll")) ;

        assertThatThrownBy(() -> userInput.validateNames(carNames)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("이름의 길이는 5자를 넘지 않아야 합니다.");
    }

    @Test
    void 시도_횟수_0_미만에_대한_예외_처리() {
        assertThatThrownBy(() -> userInput.validateTryNumber(0)).isInstanceOf(
                IllegalArgumentException.class).hasMessage("시도 횟수는 0을 넘어야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
